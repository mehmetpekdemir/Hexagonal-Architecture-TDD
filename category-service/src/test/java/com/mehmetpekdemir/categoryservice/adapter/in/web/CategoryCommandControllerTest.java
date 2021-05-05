package com.mehmetpekdemir.categoryservice.adapter.in.web;

import com.mehmetpekdemir.categoryservice.adapter.in.web.request.CreateCategoryRequest;
import com.mehmetpekdemir.categoryservice.application.port.in.CategoryCommandUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
class CategoryCommandControllerTest {

    @InjectMocks
    private CategoryCommandController categoryCommandController;

    @Mock
    private CategoryCommandUseCase categoryCommandUseCase;

    @Test
    void it_should_create_category() {
        //given
        final var createCategoryRequest = new CreateCategoryRequest();
        createCategoryRequest.setName("category name");

        //when
        categoryCommandController.createCategory(createCategoryRequest);

        //then
        verify(categoryCommandUseCase).createCategory(createCategoryRequest.toModel());
    }

}