package com.mehmetpekdemir.categoryservice.adapter.in.web;

import com.mehmetpekdemir.categoryservice.adapter.in.web.request.CreateCategoryRequest;
import com.mehmetpekdemir.categoryservice.adapter.in.web.response.CategoryResponse;
import com.mehmetpekdemir.categoryservice.application.port.in.CategoryCommandUseCase;
import com.mehmetpekdemir.commonservice.rest.BaseController;
import com.mehmetpekdemir.commonservice.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
class CategoryCommandController extends BaseController {

    private final CategoryCommandUseCase categoryCommandUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response<CategoryResponse> createCategory(@Valid @RequestBody CreateCategoryRequest createCategoryRequest) {
        final var createCategoryCommand = createCategoryRequest.convertCategoryRequestToCategoryCommand();
        final var category = categoryCommandUseCase.createCategory(createCategoryCommand);
        final var response = CategoryResponse.convertCategoryToCategoryResponse(category);
        return respond(response);
    }

}
