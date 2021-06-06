package com.mehmetpekdemir.categoryservice.application.port.in;

import com.mehmetpekdemir.categoryservice.domain.Category;

import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface ListParentCategoryUseCase {

    List<Category> listParentCategory();

}
