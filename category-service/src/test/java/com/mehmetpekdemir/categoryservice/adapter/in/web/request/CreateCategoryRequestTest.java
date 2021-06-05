package com.mehmetpekdemir.categoryservice.adapter.in.web.request;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
class CreateCategoryRequestTest {

    @Test
    void it_should_convert_create_category_request_to_create_category_command() {
        //given
        final String parentId = UUID.randomUUID().toString();
        final var createCategoryRequest = new CreateCategoryRequest();
        createCategoryRequest.setParentId(parentId);
        createCategoryRequest.setName("category name");
        createCategoryRequest.setDescription("category description");
        createCategoryRequest.setStatus("active");

        //when
        final var createCategoryCommand = createCategoryRequest.convertCategoryRequestToCategoryCommand();

        //then
        then(createCategoryCommand.getParentId()).isEqualTo(parentId);
        then(createCategoryCommand.getName()).isEqualTo("category name");
        then(createCategoryCommand.getDescription()).isEqualTo("category description");
        then(createCategoryCommand.getStatus()).isEqualTo("active");
    }

}