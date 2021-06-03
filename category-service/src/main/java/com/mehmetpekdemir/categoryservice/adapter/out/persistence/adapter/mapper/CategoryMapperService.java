package com.mehmetpekdemir.categoryservice.adapter.out.persistence.adapter.mapper;

import com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity.CategoryJpaEntity;
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

    public CategoryJpaEntity convertCommandToEntity(CreateCategoryCommand createCategoryCommand) {
        final var uuid = UUID.randomUUID().toString();
        final var status = Status.of(createCategoryCommand.getStatus()).orElse(Status.PASSIVE);
        final var categoryJpaEntity = new CategoryJpaEntity();
        categoryJpaEntity.setUuid(uuid);
        categoryJpaEntity.setParentId(createCategoryCommand.getParentId());
        categoryJpaEntity.setName(createCategoryCommand.getName());
        categoryJpaEntity.setDescription(createCategoryCommand.getDescription());
        categoryJpaEntity.setStatus(status);
        return categoryJpaEntity;
    }

    public Category convertEntityToDomain(CategoryJpaEntity categoryJpaEntity) {
        return Category.builder()
                .name(categoryJpaEntity.getName())
                .description(categoryJpaEntity.getDescription())
                .status(categoryJpaEntity.getStatus().toString())
                .build();
    }

}
