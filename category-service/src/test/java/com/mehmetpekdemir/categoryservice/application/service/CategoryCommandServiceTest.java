package com.mehmetpekdemir.categoryservice.application.service;

import com.mehmetpekdemir.categoryservice.application.port.in.command.CreateCategoryCommand;
import com.mehmetpekdemir.categoryservice.application.port.out.CategoryCommandPort;
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
class CategoryCommandServiceTest {

    @InjectMocks
    private CategoryCommandService categoryCommandService;

    @Mock
    private CategoryCommandPort categoryCommandPort;

    @Test
    void it_should_success_category_create_when_category_called_with_valid_request() {
        //given
        final var createCategoryCommand = new CreateCategoryCommand();
        createCategoryCommand.setName("category name");

        //when
        categoryCommandService.createCategory(createCategoryCommand);

        //then
        verify(categoryCommandPort).createCategory(createCategoryCommand);
    }

}