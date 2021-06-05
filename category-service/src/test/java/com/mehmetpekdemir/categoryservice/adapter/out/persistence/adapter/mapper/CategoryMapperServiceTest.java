package com.mehmetpekdemir.categoryservice.adapter.out.persistence.adapter.mapper;

import com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity.CategoryEntity;
import com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity.Status;
import com.mehmetpekdemir.categoryservice.application.port.in.command.CreateCategoryCommand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
class CategoryMapperServiceTest {

    @InjectMocks
    private CategoryMapperService categoryMapperService;

    @Test
    void it_should_convert_command_to_entity() {
        //given
        final String parentId = UUID.randomUUID().toString();
        final var createCategoryCommand = CreateCategoryCommand.builder()
                .parentId(parentId)
                .name("category name")
                .description("category description")
                .status("active")
                .build();

        //when
        final var categoryEntity = categoryMapperService.convertCommandToEntity(createCategoryCommand);

        //then
        then(categoryEntity.getParentId()).isEqualTo(parentId);
        then(categoryEntity.getName()).isEqualTo("category name");
        then(categoryEntity.getDescription()).isEqualTo("category description");
        then(categoryEntity.getStatus()).isEqualTo(Status.ACTIVE);
    }

    @Test
    void it_should_convert_entity_to_domain() {
        //given
        final String uuid = UUID.randomUUID().toString();
        final var categoryEntity = new CategoryEntity();
        categoryEntity.setParentId(null);
        categoryEntity.setUuid(uuid);
        categoryEntity.setName("category name");
        categoryEntity.setDescription("category description");
        categoryEntity.setStatus(Status.ACTIVE);

        //when
        final var category = categoryMapperService.convertEntityToDomain(categoryEntity);

        //then
        then(category.getName()).isEqualTo("category name");
        then(category.getDescription()).isEqualTo("category description");
        then(category.getStatus()).isEqualTo("ACTIVE");
    }

}