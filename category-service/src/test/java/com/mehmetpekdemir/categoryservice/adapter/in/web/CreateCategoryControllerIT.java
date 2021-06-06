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

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@IT
class CreateCategoryControllerIT extends AbstractIT {

    private final ParameterizedTypeReference<Response<CategoryResponse>> responseParameterizedTypeReference = new ParameterizedTypeReference<>() {
    };

    @Test
    void it_should_create_category_when_category_called_with_valid_request() {
        //given
        final String url = "/api/v1/category";

        final var createCategoryRequest = new CreateCategoryRequest();
        createCategoryRequest.setName("category name");
        createCategoryRequest.setDescription("category description");
        createCategoryRequest.setStatus("active");

        //when
        final var categoryResponse = testRestTemplate
                .exchange(url, HttpMethod.POST,
                        new HttpEntity<>(createCategoryRequest), responseParameterizedTypeReference);

        //then
        assertThat(categoryResponse).isNotNull();
        assertThat(categoryResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(categoryResponse.getBody().getData().getName()).isEqualTo("category name");
        assertThat(categoryResponse.getBody().getData().getDescription()).isEqualTo("category description");
        assertThat(categoryResponse.getBody().getData().getStatus()).isEqualTo("ACTIVE");
    }

}