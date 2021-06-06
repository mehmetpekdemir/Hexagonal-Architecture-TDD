package com.mehmetpekdemir.categoryservice.application.service;

import com.mehmetpekdemir.categoryservice.application.port.out.ListParentCategoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
class ListParentCategoryServiceTest {

    @InjectMocks
    private ListParentCategoryService listParentCategoryService;

    @Mock
    private ListParentCategoryPort listParentCategoryPort;

    @Test
    void it_should_list_parent_category() {
        //given

        //when
        listParentCategoryService.listParentCategory();

        //then
        verify(listParentCategoryPort).listParentCategory();
    }

}
