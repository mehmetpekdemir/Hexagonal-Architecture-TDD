package com.mehmetpekdemir.categoryservice.adapter.in.web;

import com.mehmetpekdemir.categoryservice.adapter.in.web.request.CreateCategoryRequest;
import com.mehmetpekdemir.categoryservice.application.port.in.CategoryCommandUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
class CategoryCommandController {

    private final CategoryCommandUseCase categoryCommandUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createCategory(@Valid @RequestBody CreateCategoryRequest createCategoryRequest) {
        final var response = categoryCommandUseCase.createCategory(createCategoryRequest.toModel());
        return ResponseEntity.ok(response);
    }

}
