package com.hmh.core;

import javax.servlet.ServletContextEvent;

import com.hmh.common.Logger;
import org.springframework.web.context.ContextLoaderListener;


public class InitialListener extends ContextLoaderListener {
    private static Logger logger = Logger.getLogger(InitialListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        logger.info("start contextDestroyed.");
        super.contextDestroyed(event);

    }


    @Override
    public void contextInitialized(ServletContextEvent event) {
        logger.info("start contextInitialized.");

        super.contextInitialized(event);

    }
}