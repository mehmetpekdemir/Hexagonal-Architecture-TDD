package com.mehmetpekdemir.categoryservice.adapter.in.web.response;

import com.mehmetpekdemir.categoryservice.domain.Category;
import lombok.Builder;
import lombok.Getter;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@Builder
public final class CategoryResponse {

    private final String name;

    public static CategoryResponse from(Category category) {
        return CategoryResponse.builder()
                .name(category.getName())
                .build();
    }

}
