package com.mehmetpekdemir.categoryservice.common.rest;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(MockitoExtension.class)
class BaseControllerTest {

    @InjectMocks
    private BaseController baseController;

    @Test
    void it_should_success_respond_with_list_of_data() {
        //given
        final var dummy = new DummyResponse();
        dummy.setName("dummy name");

        final var data = new ArrayList<DummyResponse>();
        data.add(dummy);

        //when
        final var result = baseController.respond(data);

        //then
        then(result.getData().getData().get(0).getName()).isEqualTo("dummy name");
    }

    @Test
    void it_should_success_respond_with_list_of_data_and_meta() {
        //given
        final var dummy = new DummyResponse();
        dummy.setName("dummy name");

        final var data = new ArrayList<DummyResponse>();
        data.add(dummy);

        final var meta = new MetaResponse();
        meta.setLimit(10);
        meta.setCurrentPage(1);
        meta.setTotal(100L);
        meta.setTotalPage(10);

        //when
        final var result = baseController.respond(data, meta);

        //then
        then(result.getData().getData().get(0).getName()).isEqualTo("dummy name");
        then(result.getData().getMeta().getLimit()).isEqualTo(10);
        then(result.getData().getMeta().getCurrentPage()).isEqualTo(1);
        then(result.getData().getMeta().getTotal()).isEqualTo(100L);
        then(result.getData().getMeta().getTotalPage()).isEqualTo(10);
    }

    @Test
    void it_should_success_respond_with_data() {
        //given
        final var data = new DummyResponse();
        data.setName("dummy name");

        //when
        final var result = baseController.respond(data);

        //then
        then(result.getData().getName()).isEqualTo("dummy name");
    }

    @Test
    void it_should_success_respond_with_error_response() {
        //given
        final var errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("404");
        errorResponse.setErrorDescription("Page not found !");

        //when
        final var result = baseController.respond(errorResponse);

        //then
        then(result.getErrors().getErrorCode()).isEqualTo("404");
        then(result.getErrors().getErrorDescription()).isEqualTo("Page not found !");
    }

    @Setter
    @Getter
    private static final class DummyResponse {
        private String name;
    }

}