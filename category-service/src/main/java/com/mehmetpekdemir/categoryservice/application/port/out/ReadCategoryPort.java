package com.mehmetpekdemir.categoryservice.application.port.out;

import com.mehmetpekdemir.categoryservice.domain.Category;

public interface ReadCategoryPort {

    Category readCategory(String name);

}
