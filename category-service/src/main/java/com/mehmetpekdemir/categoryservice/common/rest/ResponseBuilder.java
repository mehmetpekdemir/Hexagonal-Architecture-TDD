package com.mehmetpekdemir.categoryservice.common.rest;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ResponseBuilder {

    public static <T> Response<DataResponse<T>> build(List<T> data) {
        return new Response<>(new DataResponse<>(data));
    }

    public static <T> Response<DataResponse<T>> build(List<T> data, MetaResponse meta) {
        return new Response<>(new DataResponse<>(data, meta));
    }

    public static <T> Response<T> build(T data) {
        return new Response<>(data);
    }

    public static Response<ErrorResponse> build(ErrorResponse errorResponse) {
        return new Response<>(errorResponse);
    }

}
