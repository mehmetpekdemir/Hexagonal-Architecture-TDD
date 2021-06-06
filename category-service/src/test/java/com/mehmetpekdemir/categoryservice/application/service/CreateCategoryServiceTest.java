package com.mehmetpekdemir.categoryservice.application.service;

import com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity.Status;
import com.mehmetpekdemir.categoryservice.application.port.in.command.CreateCategoryCommand;
import com.mehmetpekdemir.categoryservice.application.port.out.ExistsCategoryPort;
import com.mehmetpekdemir.categoryservice.application.port.out.InsertCategoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.verify;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
class CreateCategoryServiceTest {

    @InjectMocks
    private CreateCategoryService createCategoryService;

    @Mock
    private InsertCategoryPort insertCategoryPort;

    @Mock
    private ExistsCategoryPort existsCategoryPort;

    @Test
    void it_should_success_category_create_when_category_called_with_valid_request() {
        //given
        final var uuid = UUID.randomUUID().toString();
        final var createCategoryCommand = CreateCategoryCommand.builder()
                .parentId(uuid)
                .name("category name")
                .description("category description")
                .status(Status.ACTIVE.toString())
                .build();

        //when
        createCategoryService.createCategory(createCategoryCommand);

        //then
        verify(existsCategoryPort).existsCategory("category name");
        verify(insertCategoryPort).insertCategory(createCategoryCommand);
    }

}