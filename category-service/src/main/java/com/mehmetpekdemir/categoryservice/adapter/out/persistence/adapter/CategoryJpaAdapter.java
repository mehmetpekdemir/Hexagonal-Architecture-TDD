package com.mehmetpekdemir.categoryservice.adapter.out.persistence.adapter;

import com.mehmetpekdemir.categoryservice.adapter.out.persistence.adapter.mapper.CategoryMapperService;
import com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity.CategoryEntity;
import com.mehmetpekdemir.categoryservice.adapter.out.persistence.repository.CategoryJpaRepository;
import com.mehmetpekdemir.categoryservice.application.port.in.command.CreateCategoryCommand;
import com.mehmetpekdemir.categoryservice.application.port.out.ExistsCategoryPort;
import com.mehmetpekdemir.categoryservice.application.port.out.InsertCategoryPort;
import com.mehmetpekdemir.categoryservice.application.port.out.ListParentCategoryPort;
import com.mehmetpekdemir.categoryservice.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class CategoryJpaAdapter implements InsertCategoryPort, ExistsCategoryPort, ListParentCategoryPort {

    private final CategoryJpaRepository categoryJpaRepository;
    private final CategoryMapperService categoryMapperService;

    @Override
    public Category insertCategory(CreateCategoryCommand createCategoryCommand) {
        final var categoryEntity = categoryMapperService.convertCommandToEntity(createCategoryCommand);
        final var response = categoryJpaRepository.save(categoryEntity);
        return categoryMapperService.convertEntityToDomain(response);
    }

    @Override
    public boolean existsCategory(String name) {
        return categoryJpaRepository.existsByName(name);
    }

    @Override
    public List<Category> listParentCategory() {
        final var categoryEntityList = categoryJpaRepository.findAllByParentIdIsNotNull();
        return categoryMapperService.convertEntityListToDomainList(categoryEntityList);
    }

}
