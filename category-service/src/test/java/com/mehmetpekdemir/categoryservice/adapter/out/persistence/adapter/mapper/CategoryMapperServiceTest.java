package com.mehmetpekdemir.categoryservice.adapter.out.persistence.adapter.mapper;

import com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity.CategoryJpaEntity;
import com.mehmetpekdemir.categoryservice.application.port.in.command.CreateCategoryCommand;
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
class CategoryMapperServiceTest {

    @InjectMocks
    private CategoryMapperService categoryMapperService;

    @Test
    void it_should_convert_command_to_entity() {
        //given
        final var createCategoryCommand = new CreateCategoryCommand();
        createCategoryCommand.setName("category name");

        //when
        final var categoryJpaEntity = categoryMapperService.convertCommandToEntity(createCategoryCommand);

        //then
        then(categoryJpaEntity.getName()).isEqualTo("category name");
    }

    @Test
    void it_should_convert_entity_to_domain() {
        //given
        final var categoryJpaEntity = new CategoryJpaEntity();
        categoryJpaEntity.setName("category name");

        //when
        final var category = categoryMapperService.convertEntityToDomain(categoryJpaEntity);

        //then
        then(category.getName()).isEqualTo("category name");
    }

}