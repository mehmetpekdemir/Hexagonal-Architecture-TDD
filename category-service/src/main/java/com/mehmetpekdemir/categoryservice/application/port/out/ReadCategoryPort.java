package com.mehmetpekdemir.categoryservice.application.port.out;

import com.mehmetpekdemir.categoryservice.domain.Category;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface ReadCategoryPort {

    Category readCategory(String name);

}
