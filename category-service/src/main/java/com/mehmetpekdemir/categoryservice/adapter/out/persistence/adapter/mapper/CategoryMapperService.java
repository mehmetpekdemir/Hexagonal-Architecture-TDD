package com.mehmetpekdemir.categoryservice.adapter.out.persistence.adapter.mapper;

import com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity.CategoryJpaEntity;
import com.mehmetpekdemir.categoryservice.application.port.in.command.CreateCategoryCommand;
import com.mehmetpekdemir.categoryservice.domain.Category;
import org.springframework.stereotype.Component;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Component
public class CategoryMapperService {

    public CategoryJpaEntity from(CreateCategoryCommand createCategoryCommand) {
        final CategoryJpaEntity categoryJpaEntity = new CategoryJpaEntity();
        categoryJpaEntity.setName(createCategoryCommand.getName());
        return categoryJpaEntity;
    }

    public Category from(CategoryJpaEntity categoryJpaEntity) {
        return Category.withId(categoryJpaEntity.getId(), categoryJpaEntity.getName());
    }

}
