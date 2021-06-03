package com.mehmetpekdemir.categoryservice.adapter.in.web.response;

import com.mehmetpekdemir.categoryservice.domain.Category;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class CategoryResponseTest {

    @Test
    void it_should_convert_category_to_category_response() {
        //given
        final var category = Category.builder()
                .name("category name")
                .description("category description")
                .status("active")
                .build();

        //when
        final var categoryResponse = CategoryResponse.convertCategoryToCategoryResponse(category);

        //then
        then(categoryResponse.getName()).isEqualTo("category name");
        then(categoryResponse.getDescription()).isEqualTo("category description");
        then(categoryResponse.getStatus()).isEqualTo("active");
    }

}