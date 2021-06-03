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
    private final String description;
    private final String status;

    public static CategoryResponse convertCategoryToCategoryResponse(Category category) {
        return CategoryResponse.builder()
                .name(category.getName())
                .description(category.getDescription())
                .status(category.getStatus())
                .build();
    }

}
