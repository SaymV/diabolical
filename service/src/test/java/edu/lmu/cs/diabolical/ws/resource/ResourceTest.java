package edu.lmu.cs.diabolical.ws.resource;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

import edu.lmu.cs.diabolical.ws.resource.StringListMessageBodyProvider;

/**
 * Base class for all other resource test classes to extend. It defines a shared
 * web resource object for subclass convenience.
 */
public abstract class ResourceTest extends JerseyTest {

    protected WebResource wr;

    public ResourceTest() {
        super();
        wr = resource();
    }

    @Override
    protected AppDescriptor configure() {
        // The test web app descriptor nearly replicates web.xml except for the
        // Spring context and a container request filter.
        return new WebAppDescriptor.Builder("edu.lmu.cs.headmaster.ws.resource")
            .clientConfig(createClientConfig())
            .contextParam("contextConfigLocation", "classpath:testContext.xml")
            .contextListenerClass(ContextLoaderListener.class)
            .requestListenerClass(RequestContextListener.class)
            .servletClass(SpringServlet.class)
            .initParam(
                "com.sun.jersey.config.property.resourceConfigClass",
                "com.sun.jersey.api.core.PackagesResourceConfig"
            )
            .initParam(
                "com.sun.jersey.config.property.packages",
                "edu.lmu.cs.headmaster.ws.resource"
            )
            .initParam(
                "com.sun.jersey.spi.container.ContainerRequestFilters",
                "edu.lmu.cs.headmaster.ws.resource.SecurityContextContainerRequestFilter"
            )
            .contextPath("headmaster-test").build();
    }

    /**
     * Makes sure that our string list body reader/writer gets in there...
     */
    protected ClientConfig createClientConfig() {
        final ClientConfig config = new DefaultClientConfig();
        config.getClasses().add(StringListMessageBodyProvider.class);
        return config;
    }

}
