package com.mehmetpekdemir.categoryservice.adapter.in.web.mapper;

import com.mehmetpekdemir.categoryservice.adapter.in.web.request.CreateCategoryRequest;
import com.mehmetpekdemir.categoryservice.adapter.in.web.response.CategoryResponse;
import com.mehmetpekdemir.categoryservice.application.port.in.command.CreateCategoryCommand;
import com.mehmetpekdemir.categoryservice.domain.Category;
import org.springframework.stereotype.Component;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Component
public class CategoryConvertorService {

    public CreateCategoryCommand convertCreateCategoryRequestToCreateCategoryCommand(CreateCategoryRequest createCategoryRequest) {
        final var createCategoryCommand = new CreateCategoryCommand();
        createCategoryCommand.setName(createCategoryRequest.getName());
        return createCategoryCommand;
    }

    public CategoryResponse convertCategoryToCategoryResponse(Category category) {
        final var categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        return categoryResponse;
    }

}
