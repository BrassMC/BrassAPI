package io.github.brassmc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrassAPI {
    public static final String MOD_ID = "brassapi";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public BrassAPI() {
        LOGGER.info("Brass API initialised");
    }
}
