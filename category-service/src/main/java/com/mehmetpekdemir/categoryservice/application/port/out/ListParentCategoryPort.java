package com.mehmetpekdemir.categoryservice.application.port.out;

import com.mehmetpekdemir.categoryservice.domain.Category;

import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface ListParentCategoryPort {

    List<Category> listParentCategory();

}
