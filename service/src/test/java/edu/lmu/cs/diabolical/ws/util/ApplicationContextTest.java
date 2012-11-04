package edu.lmu.cs.diabolical.ws.util;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Base class for Spring bean unit tests, such as daos and service
 * implementations. Its main purpose is to create and hold the Spring test
 * context that instantiates all of the beans that may be tested.
 */
public abstract class ApplicationContextTest {

    protected ConfigurableApplicationContext applicationContext;

    @Before
    public void setUpApplicationContextTest() {
        applicationContext = new ClassPathXmlApplicationContext("testContext.xml");
    }

    @After
    public void shutDownApplicationContextTest() {
        applicationContext.close();
        applicationContext = null;
    }

}
