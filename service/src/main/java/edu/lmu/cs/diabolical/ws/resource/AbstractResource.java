package edu.lmu.cs.diabolical.ws.resource;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import edu.lmu.cs.diabolical.ws.util.ServiceException;

/**
 * A base class for the resources, supplying error keys, a logger, a validation method, and fields
 * for JAX-RS context objects.
 */
public class AbstractResource {

    // Error keys.  No resource returns user-displayable text, since that is the responsibility
    // of a client.  Instead, the services provide mnemonic error keys.  We've purposely
    // refrained from using a properties file (they're not key-value pairs), a separate enum
    // (we'd need long references or static imports), or injection (they're not variables,
    // but constants).
    public static final String SKIP_TOO_SMALL = "skip.too.small";
    public static final String MAX_TOO_LARGE = "max.too.large";
    public static final String QUERY_REQUIRED = "query.required";
    public static final String ARGUMENT_CONFLICT = "argument.conflict";
    public static final String MALFORMED_ARGUMENT_DATE = "argument.date.malformed";
    public static final String MISSING_ARGUMENT_DATE = "argument.date.missing";
    public static final String UNSUPPORTED_ENCODING = "encoding.not.supported";
    public static final String INVALID_USER = "user.invalid";
    public static final String USER_FORBIDDEN = "user.forbidden";

    protected Logger logger = Logger.getLogger(getClass());

    // URI information automatically injected by JAX-RS framework on each resource call.
    @Context
    protected UriInfo uriInfo;

    // Security context automatically injected by JAX-RS framework on each resource call.
    @Context
    protected SecurityContext securityContext;

/*
    // A dao for security checking.
    protected UserDao userDao;

    // Every resource needs a user dao.
    protected AbstractResource(UserDao userDao) {
        this.userDao = userDao;
    }
*/

    /**
     * Checks that a condition is true and throws a <code>ServiceException</code> with the given
     * integer HTTP response code if it is not.  Example:
     * <pre>
     *     validate(student != null, 404, NO_USER);
     * </pre>
     */
    protected void validate(boolean condition, int httpStatus, String errorKey) {
        if (!condition) {
            throw new ServiceException(httpStatus, errorKey);
        }
    }

    /**
     * Convenience method that takes a <code>Response.Status</code> instead of an int.
     */
    protected void validate(boolean condition, Response.Status httpStatus, String errorKey) {
        validate(condition, httpStatus.getStatusCode(), errorKey);
    }

    /**
     * Utility method for checking a paginated request's parameters for validity.
     */
    protected void validatePagination(int skip, int max, int minimumSkip, int maximumSkip) {
        validate(skip >= minimumSkip, Response.Status.BAD_REQUEST, SKIP_TOO_SMALL);
        validate(max <= maximumSkip, Response.Status.BAD_REQUEST, MAX_TOO_LARGE);
    }

    /**
     * Utility method for checking an input interval's validity.
     */
    protected Interval validateInterval(String startDate, String endDate) {
        validate(startDate != null, Response.Status.BAD_REQUEST, MISSING_ARGUMENT_DATE);
        validate(endDate != null, Response.Status.BAD_REQUEST, MISSING_ARGUMENT_DATE);

        try {
            return new Interval(new DateTime(URLDecoder.decode(startDate, "UTF-8")),
                new DateTime(URLDecoder.decode(endDate, "UTF-8")));
        } catch(IllegalArgumentException iae) {
            throw new ServiceException(Response.Status.BAD_REQUEST, MALFORMED_ARGUMENT_DATE);
        } catch(UnsupportedEncodingException uee) {
            throw new ServiceException(Response.Status.INTERNAL_SERVER_ERROR, UNSUPPORTED_ENCODING);
        }
    }

    /**
     * Logs the currently accessed uri.  While this data can also be found in the web server's
     * logs, it can be useful in providing some context for debugging when reading the regular
     * application logs.
     */
    protected void logServiceCall() {
        // Sometimes there is no uriInfo, such as when the resource call is
        // invoked directly as a Java method.
        if (logger.isDebugEnabled() && (uriInfo != null)) {
            logger.debug("Invoking " + uriInfo.getAbsolutePath());
        }
    }

    /**
     * Preprocesses a query for a URI by trimming, urldecoding, and validating that the skip and
     * max parameters make sense.
     *
     * @return the processed query.
     * @throws a ServiceException resulting in a HTTP 400 if the query parameter is missing or a
     *     ServiceException resulting in an HTTP 500 if the JVM for any reason doesn't understand
     *     the encoding scheme used to decoding the URL.
     */
    protected String preprocessQuery(String q, int skip, int max, int minimumSkip, int maximumSkip) {
        try {
            // We trim before checking validity.
            String query = StringUtils.trimToNull(q != null ? URLDecoder.decode(q, "UTF-8") : null);
            validate(query != null, Response.Status.BAD_REQUEST, QUERY_REQUIRED);
            validatePagination(skip, max, minimumSkip, maximumSkip);
            return query;
        } catch (UnsupportedEncodingException e) {
            throw new ServiceException(Response.Status.INTERNAL_SERVER_ERROR, UNSUPPORTED_ENCODING);
        }
    }

    /**
     * Preprocesses a query for a URI by trimming, urldecoding, and validating that the skip and
     * max parameters make sense. Allows for a null query value.
     *
     * @return the processed query.
     * @throws a ServiceException resulting in an HTTP 500 if the JVM for any reason doesn't understand
     *     the encoding scheme used to decoding the URL.
     */
    protected String preprocessNullableQuery(String q, int skip, int max, int minimumSkip, int maximumSkip) {
        try {
            // We trim before checking validity.
            String query = StringUtils.trimToNull(q != null ? URLDecoder.decode(q, "UTF-8") : null);
            validatePagination(skip, max, minimumSkip, maximumSkip);
            return query;
        } catch (UnsupportedEncodingException e) {
            throw new ServiceException(Response.Status.INTERNAL_SERVER_ERROR, UNSUPPORTED_ENCODING);
        }
    }

    /**
     * Returns a datetime object for a string in a null-safe way.
     *
     * @return null if the input is null, or else the datetime object for the string produced
     *     by Joda Time.
     * @throws ServiceException to generate an HTTP 400 with the message for a malformed date
     *     argument if Joda Time cannot convert the input string.
     */
    protected DateTime toDateTime(String dateString) {
        try {
            return dateString == null ? null : new DateTime(dateString);
        } catch (IllegalArgumentException iae) {
            throw new ServiceException(Response.Status.BAD_REQUEST, MALFORMED_ARGUMENT_DATE);
        }
    }
}
