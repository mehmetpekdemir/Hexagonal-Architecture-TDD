package com.mehmetpekdemir.categoryservice.adapter.out.persistence.adapter;

import com.mehmetpekdemir.categoryservice.adapter.out.persistence.adapter.mapper.CategoryMapperService;
import com.mehmetpekdemir.categoryservice.adapter.out.persistence.repository.CategoryJpaRepository;
import com.mehmetpekdemir.categoryservice.application.port.in.command.CreateCategoryCommand;
import com.mehmetpekdemir.categoryservice.application.port.out.ExistsCategoryPort;
import com.mehmetpekdemir.categoryservice.application.port.out.InsertCategoryPort;
import com.mehmetpekdemir.categoryservice.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class CategoryJpaAdapter implements InsertCategoryPort, ExistsCategoryPort {

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

}
