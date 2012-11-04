package edu.lmu.cs.diabolical.ws.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.sun.jersey.core.provider.AbstractMessageReaderWriterProvider;

/**
 * A MessageBodyWriter for List<String> responses, which, shockingly, do not
 * appear to be supported by default in Jersey.
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StringListMessageBodyProvider extends AbstractMessageReaderWriterProvider<List<String>> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations,
            MediaType mediaType) {
        return isListOfStrings(type, genericType);
    }

    @Override
    public void writeTo(List<String> t, Class<?> type, Type genericType, Annotation[] annotations,
            MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) throws IOException, WebApplicationException {
        new ObjectMapper().writeValue(entityStream, t);
    }

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations,
            MediaType mediaType) {
        return isListOfStrings(type, genericType);
    }

    @Override
    public List<String> readFrom(Class<List<String>> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
                    throws IOException, WebApplicationException {
        return new ObjectMapper().readValue(entityStream, new TypeReference<List<String>>() {});
    }

    private boolean isListOfStrings(Class<?> type, Type genericType) {
        return (List.class.isAssignableFrom(type) && genericType instanceof ParameterizedType) ?
                (((ParameterizedType)genericType).getActualTypeArguments().length == 1) &&
                        ((ParameterizedType)genericType).getActualTypeArguments()[0]
                                .equals(String.class) :
                false;
    }

}
