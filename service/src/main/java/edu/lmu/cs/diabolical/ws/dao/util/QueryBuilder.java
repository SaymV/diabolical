package edu.lmu.cs.diabolical.ws.dao.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * QueryBuilder is a builder that constructs a Hibernate query (HQL) from an
 * initial string and any number of "clauses" or arbitrary strings (which must
 * comply with the HQL syntax). Clauses represent conditions based on a
 * particular value; the resulting appended string follows Hibernate's format
 * for supplying parameters (i.e., ":identifier").
 */
public class QueryBuilder {

    private Logger logger = Logger.getLogger(getClass());

    // Parameters must start with a lowercase ASCII letter.
    private static final Pattern PARAMETER_PATTERN = Pattern.compile(":([a-z]\\w*)");

    private StringBuilder stringBuilder;
    private Map<String, Object> parameters = new HashMap<String, Object>();
    private List<String> clauses = new ArrayList<String>();
    private String queryString;
    private String afterWhereClauseString;

    /**
     * Produces a new query builder with the given initial string.
     */
    public QueryBuilder(final String initialString) {
        this(initialString, null);
    }

    /**
     * Creates a new query builder with the given initial and after-where-clause
     * strings.
     */
    public QueryBuilder(final String initialString, final String afterWhereClauseString) {
        stringBuilder = new StringBuilder(initialString);
        this.afterWhereClauseString = afterWhereClauseString;
    }

    /**
     * Throws an <code>IllegalStateException</code> if this builder has already
     * built a query. Used to guard the build operations.
     */
    private void assertNotBuilt() {
        if (queryString != null) {
            throw new IllegalStateException("The query has already been built");
        }
    }

    /**
     * Appends an arbitrary chunk of text to the query builder.
     */
    public QueryBuilder append(String text) {
        assertNotBuilt();
        stringBuilder.append(text);
        return this;
    }

    /**
     * Adds an HQL clause to the list of clauses, finding at most one named
     * parameter within the clause, and adding it and its associated value to
     * the parameter map. For example, calling <code>clause(":x > 5", 10)</code>
     * will add the clause ":x > 5" to clauses, and the mapping
     * <code>["x" => 10]</code> to map.
     */
    public QueryBuilder clause(String condition, Object paramValue) {
        assertNotBuilt();
        clauses.add(condition);
        Matcher matcher = PARAMETER_PATTERN.matcher(condition);
        if (matcher.find()) {
            parameters.put(matcher.group(1), paramValue);
        }
        return this;
    }

    /**
     * Puts the base string, the clauses, and the parameters all together into a
     * Hibernate query object.
     * 
     * This is a template method; it uses createQuery to instantiate the query
     * object to be built and finishQuery to perform any final operations before
     * returning the query. Subclasses can override these methods as needed.
     */
    public Query build(Session session) {
        boolean first = true;
        for (String clause: clauses) {
            stringBuilder.append(first ? " where " : " and ").append(clause);
            first = false;
        }

        if (afterWhereClauseString != null) {
            stringBuilder.append(" ").append(afterWhereClauseString);
        }

        queryString = stringBuilder.toString();

        // If there's no session, we can't build a query. Bail.
        if (session == null) {
            return null;
        }

        Query query = createQuery(session, queryString);
        for (Map.Entry<String, Object> e : parameters.entrySet()) {
            query.setParameter(e.getKey(), e.getValue());
        }

        if (logger.isDebugEnabled()) {
            logger.debug("QUERY: " + getQueryString() + " PARAMS: " + getParameters());
        }
        return finishQuery(query);
    }

    /**
     * Returns the query string that has been built so far.
     */
    public String getQueryString() {
        return stringBuilder.toString();
    }

    /**
     * Retrieves the query parameters that have been added so far.
     */
    public Map<String, Object> getParameters() {
        return parameters;
    }

    /**
     * Factory method for creating the initial Query object.
     */
    protected Query createQuery(Session session, String queryString) {
        return session.createQuery(queryString);
    }
    
    /**
     * Wrap-up method for finishing the Query object before returning.
     */
    protected Query finishQuery(Query query) {
        // For Hibernate queries, this is a no-op.
        return query;
    }

}
