package com.mehmetpekdemir.categoryservice.common.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mehmetpekdemir.categoryservice.common.exception.CategoryBusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(MockitoExtension.class)
class RestExceptionHandlerTest {

    private MockMvc mockMvc;

    private JacksonTester<Response> responseJacksonTester;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());

        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/messages");
        messageSource.setUseCodeAsDefaultMessage(true);

        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new DummyController())
                .setControllerAdvice(new RestExceptionHandler(messageSource))
                .build();
    }

    @Test
    void it_should_catch_category_business_exception() throws Exception {
        //given
        final var url = "/handle-category-business-exception";

        //when
        final var mvcResult = this.mockMvc.perform(get(url))
                .andDo(print())
                .andReturn();
        //then
        final var errorResponse = responseJacksonTester.parse(mvcResult.getResponse().getContentAsString()).getObject();
        then(errorResponse.getData()).isNull();
        then(errorResponse.getErrors().getErrorCode()).isEqualTo("400");
        then(errorResponse.getErrors().getErrorDescription()).isEqualTo("Category already exists.");
    }

    @Test
    void it_should_catch_bind_exception() throws Exception {
        //given
        final var url = "/handle-bind-exception";

        //when
        final var mvcResult = this.mockMvc.perform(get(url))
                .andDo(print())
                .andReturn();
        //then
        final var errorResponse = responseJacksonTester.parse(mvcResult.getResponse().getContentAsString()).getObject();
        then(errorResponse.getData()).isNull();
        then(errorResponse.getErrors().getErrorCode()).isEqualTo("1");
        then(errorResponse.getErrors().getErrorDescription()).isEqualTo("System error occurred.");
    }

    @Test
    void it_should_catch_method_argument_not_valid_exception() throws Exception {
        //given
        final var url = "/handle-method-argument-not-valid-exception";

        //when
        final var mvcResult = this.mockMvc.perform(get(url))
                .andDo(print())
                .andReturn();
        //then
        final var errorResponse = responseJacksonTester.parse(mvcResult.getResponse().getContentAsString()).getObject();
        then(errorResponse.getData()).isNull();
        then(errorResponse.getErrors().getErrorCode()).isEqualTo("1");
        then(errorResponse.getErrors().getErrorDescription()).isEqualTo("System error occurred.");
    }

    @Test
    void it_should_catch_method_not_supported_exception() throws Exception {
        //given
        final var url = "/handle-method-not-supported-exception";

        //when
        final var mvcResult = this.mockMvc.perform(get(url))
                .andDo(print())
                .andReturn();
        //then
        final var errorResponse = responseJacksonTester.parse(mvcResult.getResponse().getContentAsString()).getObject();
        then(errorResponse.getData()).isNull();
        then(errorResponse.getErrors().getErrorCode()).isEqualTo("9");
        then(errorResponse.getErrors().getErrorDescription()).isEqualTo("Method not supported");
    }

    @Test
    void it_should_catch_method_argument_type_mismatch_exception() throws Exception {
        //given
        final var url = "/handle-method-argument-type-mismatch-exception";

        //when
        final var mvcResult = this.mockMvc.perform(get(url))
                .andDo(print())
                .andReturn();
        //then
        final var errorResponse = responseJacksonTester.parse(mvcResult.getResponse().getContentAsString()).getObject();
        then(errorResponse.getData()).isNull();
        then(errorResponse.getErrors().getErrorCode()).isEqualTo("8");
        then(errorResponse.getErrors().getErrorDescription()).isEqualTo("null parameter type mismatch.");
    }

    @Test
    void it_should_catch_exception() throws Exception {
        //given
        final var url = "/exception";

        //when
        final var mvcResult = this.mockMvc.perform(get(url))
                .andDo(print())
                .andReturn();
        //then
        final var errorResponse = responseJacksonTester.parse(mvcResult.getResponse().getContentAsString()).getObject();
        then(errorResponse.getData()).isNull();
        then(errorResponse.getErrors().getErrorCode()).isEqualTo("1");
        then(errorResponse.getErrors().getErrorDescription()).isEqualTo("System error occurred.");
    }

    @RestController
    private static class DummyController {

        @GetMapping("/handle-category-business-exception")
        public void handleCategoryBusinessException() throws CategoryBusinessException {
            throw new CategoryBusinessException("category.already.exists");
        }

        @GetMapping("/handle-bind-exception")
        public void handleBindException() throws BindException {
            throw new BindException(null);
        }

        @GetMapping("/handle-method-argument-not-valid-exception")
        public void handleInvalidArgumentException() throws MethodArgumentNotValidException {
            throw new MethodArgumentNotValidException(null, null);
        }

        @GetMapping("/handle-method-not-supported-exception")
        public void handleMethodNotSupportedException() throws HttpRequestMethodNotSupportedException {
            throw new HttpRequestMethodNotSupportedException(null);
        }

        @GetMapping("/handle-method-argument-type-mismatch-exception")
        public void handleMethodArgumentTypeMismatchException() throws MethodArgumentTypeMismatchException {
            throw new MethodArgumentTypeMismatchException(null, null, null, null, null);
        }

        @GetMapping("/exception")
        public void handleException() throws Exception {
            throw new Exception("internal server error");
        }

    }

}