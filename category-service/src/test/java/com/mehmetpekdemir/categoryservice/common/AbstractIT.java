package com.mehmetpekdemir.categoryservice.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public abstract class AbstractIT {

    @Autowired
    protected TestRestTemplate testRestTemplate;

    @LocalServerPort
    protected Integer port;

}
