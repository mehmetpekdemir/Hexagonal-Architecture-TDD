package com.mehmetpekdemir.categoryservice.adapter.in.web;

import com.mehmetpekdemir.categoryservice.adapter.in.web.request.CreateCategoryRequest;
import com.mehmetpekdemir.categoryservice.adapter.in.web.response.CategoryResponse;
import com.mehmetpekdemir.categoryservice.common.AbstractIT;
import com.mehmetpekdemir.categoryservice.common.IT;
import com.mehmetpekdemir.categoryservice.common.rest.Response;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@IT
class CategoryCommandControllerIT extends AbstractIT {

    private final ParameterizedTypeReference<Response<CategoryResponse>> responseParameterizedTypeReference = new ParameterizedTypeReference<>() {
    };

    @Test
    void it_should_create_category() {
        //given
        CreateCategoryRequest createCategoryRequest = new CreateCategoryRequest();
        createCategoryRequest.setName("category name2");

        //when
        ResponseEntity<Response<CategoryResponse>> categoryResponse = testRestTemplate
                .exchange("/api/v1/category", HttpMethod.POST,
                        new HttpEntity(createCategoryRequest), responseParameterizedTypeReference
                );

        //then
        System.out.println("Response: " + categoryResponse);
        assertThat(categoryResponse).isNotNull();
        assertThat(categoryResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(categoryResponse.getBody().getData().getName()).isEqualTo("category name2");
    }

}