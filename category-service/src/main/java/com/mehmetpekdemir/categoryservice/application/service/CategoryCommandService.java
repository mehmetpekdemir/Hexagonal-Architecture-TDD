package com.mehmetpekdemir.categoryservice.application.service;

import com.mehmetpekdemir.categoryservice.application.port.in.CategoryCommandUseCase;
import com.mehmetpekdemir.categoryservice.application.port.in.command.CreateCategoryCommand;
import com.mehmetpekdemir.categoryservice.application.port.out.CategoryCommandPort;
import com.mehmetpekdemir.categoryservice.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryCommandService implements CategoryCommandUseCase {

    private final CategoryCommandPort categoryCommandPort;

    @Override
    public Category createCategory(CreateCategoryCommand createCategoryCommand) {
        return categoryCommandPort.createCategory(createCategoryCommand);
    }

}
