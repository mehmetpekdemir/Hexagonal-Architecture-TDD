package com.mehmetpekdemir.categoryservice.adapter.in.web;

import com.mehmetpekdemir.categoryservice.adapter.in.web.request.CreateCategoryRequest;
import com.mehmetpekdemir.categoryservice.adapter.in.web.response.CategoryResponse;
import com.mehmetpekdemir.categoryservice.application.port.in.CategoryCommandUseCase;
import com.mehmetpekdemir.categoryservice.common.AbstractMvc;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@WebMvcTest(CategoryCommandController.class)
class CategoryCommandControllerMvcTest extends AbstractMvc {

    @MockBean
    private CategoryCommandUseCase categoryCommandUseCase;

    @Test
    void it_should_create_category() throws Exception {
        //given
        final var createCategoryRequest = new CreateCategoryRequest();
        createCategoryRequest.setName("category name");

        //when
        mockMvc.perform(
                post("/api/v1/category")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createCategoryRequest)))
                .andDo(print())
                .andExpect(status().isCreated());

        //then
        final var category = categoryCommandUseCase.createCategory(createCategoryRequest.toModel());
        final var response = CategoryResponse.from(category);
        then(response.getName()).isEqualTo(response.getName());
    }

}