package com.mehmetpekdemir.commonservice.rest;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@NoArgsConstructor
public class Response<T> {

    private T data;
    private ErrorResponse errors;

    public Response(T data) {
        this.data = data;
    }

    public Response(ErrorResponse errors) {
        this.errors = errors;
    }

}
