package com.mehmetpekdemir.categoryservice.adapter.in.web.mapper;

import com.mehmetpekdemir.categoryservice.adapter.in.web.request.CreateCategoryRequest;
import com.mehmetpekdemir.categoryservice.domain.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
class CategoryConvertorServiceTest {

    @InjectMocks
    private CategoryConvertorService categoryConvertorService;

    @Test
    void it_should_convert_create_category_request_to_create_category_command() {
        //given
        final var createCategoryRequest = new CreateCategoryRequest();
        createCategoryRequest.setName("category name");

        //when
        final var createCategoryCommand = categoryConvertorService.convertCreateCategoryRequestToCreateCategoryCommand(createCategoryRequest);

        //then
        then(createCategoryCommand.getName()).isEqualTo("category name");
    }

    @Test
    void it_should_convert_category_to_category_response() {
        //given
        final var category = new Category();
        category.setId(1L);
        category.setName("category name");

        //when
        final var categoryResponse = categoryConvertorService.convertCategoryToCategoryResponse(category);

        //then
        then(categoryResponse.getId()).isEqualTo(1L);
        then(categoryResponse.getName()).isEqualTo("category name");
    }

}