package edu.lmu.cs.diabolical.ws.service;

import org.apache.log4j.Logger;

/**
 * A base class for the services.
 */
public class AbstractService {

    protected Logger logger = Logger.getLogger(getClass());

    /**
     * Returns the service-level logger.
     */
    protected Logger getLogger() {
        return logger;
    }
    
}
