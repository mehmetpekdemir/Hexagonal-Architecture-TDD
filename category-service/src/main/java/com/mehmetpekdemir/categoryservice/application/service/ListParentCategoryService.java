package com.mehmetpekdemir.categoryservice.application.service;

import com.mehmetpekdemir.categoryservice.application.port.in.ListParentCategoryUseCase;
import com.mehmetpekdemir.categoryservice.application.port.out.ListParentCategoryPort;
import com.mehmetpekdemir.categoryservice.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class ListParentCategoryService implements ListParentCategoryUseCase {

    private final ListParentCategoryPort listParentCategoryPort;

    @Override
    public List<Category> listParentCategory() {
        return listParentCategoryPort.listParentCategory();
    }

}
