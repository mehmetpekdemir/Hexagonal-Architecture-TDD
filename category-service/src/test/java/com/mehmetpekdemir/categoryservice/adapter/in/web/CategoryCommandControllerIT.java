package com.mehmetpekdemir.categoryservice.adapter.in.web;

import com.mehmetpekdemir.categoryservice.adapter.in.web.request.CreateCategoryRequest;
import com.mehmetpekdemir.categoryservice.adapter.in.web.response.CategoryResponse;
import com.mehmetpekdemir.categoryservice.common.AbstractIT;
import com.mehmetpekdemir.categoryservice.common.IT;
import com.mehmetpekdemir.commonservice.rest.Response;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

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
    void it_should_success_category_create_when_category_called_with_valid_request() {
        //given
        final var createCategoryRequest = new CreateCategoryRequest();
        createCategoryRequest.setName("category name");

        //when
        final var categoryResponse = testRestTemplate
                .exchange("/api/v1/category", HttpMethod.POST,
                        new HttpEntity<>(createCategoryRequest), responseParameterizedTypeReference);

        //then
        assertThat(categoryResponse).isNotNull();
        assertThat(categoryResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(categoryResponse.getBody().getData().getName()).isEqualTo("category name");
    }

}