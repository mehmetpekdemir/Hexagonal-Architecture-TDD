package com.mehmetpekdemir.categoryservice.common.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        then(errorResponse.getErrors().getErrorCode()).isEqualTo("500");
        then(errorResponse.getErrors().getErrorDescription()).isEqualTo("internal server error");
    }

    @RestController
    private static class DummyController {

        @GetMapping("/exception")
        public void handleException() throws Exception {
            throw new Exception("internal server error");
        }

    }

}