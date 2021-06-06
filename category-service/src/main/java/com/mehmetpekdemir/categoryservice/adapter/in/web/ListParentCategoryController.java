package com.mehmetpekdemir.categoryservice.adapter.in.web;

import com.mehmetpekdemir.categoryservice.adapter.in.web.response.CategoryResponse;
import com.mehmetpekdemir.categoryservice.application.port.in.ListParentCategoryUseCase;
import com.mehmetpekdemir.categoryservice.common.rest.BaseController;
import com.mehmetpekdemir.categoryservice.common.rest.DataResponse;
import com.mehmetpekdemir.categoryservice.common.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("/api/v1/parent-category")
@RequiredArgsConstructor
public class ListParentCategoryController extends BaseController {

    private final ListParentCategoryUseCase listParentCategoryUseCase;

    @GetMapping
    public Response<DataResponse<CategoryResponse>> listParentCategory() {
        final var categories = listParentCategoryUseCase.listParentCategory();
        final var categoryResponses = CategoryResponse.convertCategoryListToCategoryResponseList(categories);
        return respond(categoryResponses);
    }

}
