package com.mehmetpekdemir.categoryservice.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@Builder
public final class Category {

    private final String name;
    private final String description;
    private final String status;

}
