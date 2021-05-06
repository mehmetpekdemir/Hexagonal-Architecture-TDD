package com.mehmetpekdemir.categoryservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Category {

    private final Long id;
    private final String name;

    public static Category withoutId(String name) {
        return new Category(null, name);
    }

    public static Category withId(Long id, String name) {
        return new Category(id, name);
    }

}
