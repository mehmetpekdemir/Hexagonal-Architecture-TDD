package com.mehmetpekdemir.categoryservice.adapter.in.web;

import com.mehmetpekdemir.categoryservice.adapter.in.web.response.CategoryResponse;
import com.mehmetpekdemir.categoryservice.common.AbstractIT;
import com.mehmetpekdemir.categoryservice.common.IT;
import com.mehmetpekdemir.categoryservice.common.rest.DataResponse;
import com.mehmetpekdemir.categoryservice.common.rest.Response;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@IT
class ListParentCategoryControllerIT extends AbstractIT {

    private final ParameterizedTypeReference<Response<DataResponse<CategoryResponse>>> responseParameterizedTypeReference = new ParameterizedTypeReference<>() {
    };

    @Test
    void it_should_list_parent_category() {
        //given
        final String url = "/api/v1/parent-category";

        //when
        final var categoryResponse = testRestTemplate
                .exchange(url, HttpMethod.GET, null, responseParameterizedTypeReference);

        //then
        assertThat(categoryResponse).isNotNull();
        assertThat(categoryResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        //TODO : Data eklenince burası datayla test edilebilir hale çevrilecek.
        // assertThat(categoryResponse.getBody().getData().getData().get(0).getName()).isEqualTo("category name");
        // assertThat(categoryResponse.getBody().getData().getData().get(0).getDescription()).isEqualTo("category description");
        // assertThat(categoryResponse.getBody().getData().getData().get(0).getStatus()).isEqualTo("ACTIVE");
    }

}
