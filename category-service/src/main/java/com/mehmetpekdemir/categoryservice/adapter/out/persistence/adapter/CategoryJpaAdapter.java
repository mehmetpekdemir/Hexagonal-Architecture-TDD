package com.mehmetpekdemir.categoryservice.adapter.out.persistence.adapter;

import com.mehmetpekdemir.categoryservice.adapter.out.persistence.repository.CategoryJpaRepository;
import com.mehmetpekdemir.categoryservice.application.port.in.command.CreateCategoryCommand;
import com.mehmetpekdemir.categoryservice.application.port.out.CategoryCommandPort;
import com.mehmetpekdemir.categoryservice.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class CategoryJpaAdapter implements CategoryCommandPort {

    private final CategoryJpaRepository categoryJpaRepository;

    @Override
    public Category createCategory(CreateCategoryCommand createCategoryCommand) {
        return Category.withId(1L, "test");
    }

}
