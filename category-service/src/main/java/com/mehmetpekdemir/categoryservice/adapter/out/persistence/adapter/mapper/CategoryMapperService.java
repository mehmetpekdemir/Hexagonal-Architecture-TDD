package com.mehmetpekdemir.categoryservice.adapter.out.persistence.adapter.mapper;

import com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity.CategoryEntity;
import com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity.Status;
import com.mehmetpekdemir.categoryservice.application.port.in.command.CreateCategoryCommand;
import com.mehmetpekdemir.categoryservice.domain.Category;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Component
public class CategoryMapperService {

    public CategoryEntity convertCommandToEntity(CreateCategoryCommand createCategoryCommand) {
        final var uuid = UUID.randomUUID().toString();
        final var status = Status.of(createCategoryCommand.getStatus()).orElse(Status.PASSIVE);
        final var categoryEntity = new CategoryEntity();
        categoryEntity.setUuid(uuid);
        categoryEntity.setParentId(createCategoryCommand.getParentId());
        categoryEntity.setName(createCategoryCommand.getName());
        categoryEntity.setDescription(createCategoryCommand.getDescription());
        categoryEntity.setStatus(status);
        return categoryEntity;
    }

    public Category convertEntityToDomain(CategoryEntity categoryEntity) {
        return Category.builder()
                .name(categoryEntity.getName())
                .description(categoryEntity.getDescription())
                .status(categoryEntity.getStatus().toString())
                .build();
    }

}
