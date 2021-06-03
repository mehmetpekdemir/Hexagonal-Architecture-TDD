package com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public enum Status {
    ACTIVE("active"),
    PASSIVE("passive"),
    DELETED("deleted");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public static Optional<Status> of(String value) {
        return Arrays.stream(values())
                .filter(type -> type.value.equalsIgnoreCase(value))
                .findFirst();
    }

}
