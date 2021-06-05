package com.mehmetpekdemir.categoryservice.application.service;

import com.mehmetpekdemir.categoryservice.application.port.in.CreateCategoryUseCase;
import com.mehmetpekdemir.categoryservice.application.port.in.command.CreateCategoryCommand;
import com.mehmetpekdemir.categoryservice.application.port.out.InsertCategoryPort;
import com.mehmetpekdemir.categoryservice.application.port.out.ReadCategoryPort;
import com.mehmetpekdemir.categoryservice.domain.Category;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService implements CreateCategoryUseCase {

    private final InsertCategoryPort insertCategoryPort;
    private final ReadCategoryPort readCategoryPort;

    @Override
    @SneakyThrows
    public Category createCategory(CreateCategoryCommand createCategoryCommand) {
        final var category = readCategoryPort.readCategory(createCategoryCommand.getName());
        //TODO : exception and messages .
        if (category != null) {
            throw new Exception("category name must be unique");
        }

        return insertCategoryPort.insertCategory(createCategoryCommand);
    }

}
