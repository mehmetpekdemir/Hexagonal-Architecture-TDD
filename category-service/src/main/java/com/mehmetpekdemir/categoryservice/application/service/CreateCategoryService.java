package com.mehmetpekdemir.categoryservice.application.service;

import com.mehmetpekdemir.categoryservice.application.port.in.CreateCategoryUseCase;
import com.mehmetpekdemir.categoryservice.application.port.in.command.CreateCategoryCommand;
import com.mehmetpekdemir.categoryservice.application.port.out.ExistsCategoryPort;
import com.mehmetpekdemir.categoryservice.application.port.out.InsertCategoryPort;
import com.mehmetpekdemir.categoryservice.common.exception.CategoryBusinessException;
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
public class CreateCategoryService implements CreateCategoryUseCase {

    private final InsertCategoryPort insertCategoryPort;
    private final ExistsCategoryPort existsCategoryPort;

    @Override
    public Category createCategory(CreateCategoryCommand createCategoryCommand) {
        final boolean exists = existsCategoryPort.existsCategory(createCategoryCommand.getName());
        isExists(exists);

        return insertCategoryPort.insertCategory(createCategoryCommand);
    }

    private void isExists(boolean exists) {
        if (exists) {
            throw new CategoryBusinessException("category.already.exists");
        }
    }

}
