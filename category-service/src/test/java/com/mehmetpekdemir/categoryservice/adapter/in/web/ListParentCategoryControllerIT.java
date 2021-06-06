package com.mehmetpekdemir.categoryservice.adapter.in.web;


import com.mehmetpekdemir.categoryservice.adapter.in.web.request.CreateCategoryRequest;
import com.mehmetpekdemir.categoryservice.adapter.in.web.response.CategoryResponse;
import com.mehmetpekdemir.categoryservice.common.AbstractIT;
import com.mehmetpekdemir.categoryservice.common.IT;
import com.mehmetpekdemir.categoryservice.common.rest.DataResponse;
import com.mehmetpekdemir.categoryservice.common.rest.Response;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@IT
class ListParentCategoryControllerIT extends AbstractIT {

    private final ParameterizedTypeReference<Response<DataResponse<CategoryResponse>>> responseParameterizedTypeReference = new ParameterizedTypeReference<>() {
    };

    private final ParameterizedTypeReference<Response<CategoryResponse>> createType = new ParameterizedTypeReference<>() {
    };

    @Test
    void it_should_list_parent_category() {
        //given
        final String parentId = UUID.randomUUID().toString();
        final var createCategoryRequest = new CreateCategoryRequest();
        createCategoryRequest.setParentId(parentId);
        createCategoryRequest.setName("category name");
        createCategoryRequest.setDescription("category description");
        createCategoryRequest.setStatus("active");

        //when
        testRestTemplate
                .exchange("/api/v1/category", HttpMethod.POST,
                        new HttpEntity<>(createCategoryRequest), createType);

        //TODO : yukarıdaki kısım silinip default data eklenecek.

        //given
        final String url = "/api/v1/parent-category";

        //when
        final var categoryResponse = testRestTemplate
                .exchange(url, HttpMethod.GET, null, responseParameterizedTypeReference);

        //then
        assertThat(categoryResponse).isNotNull();
        assertThat(categoryResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(categoryResponse.getBody().getData().getData().get(0).getName()).isEqualTo("category name");
        assertThat(categoryResponse.getBody().getData().getData().get(0).getDescription()).isEqualTo("category description");
        assertThat(categoryResponse.getBody().getData().getData().get(0).getStatus()).isEqualTo("ACTIVE");
    }

}
