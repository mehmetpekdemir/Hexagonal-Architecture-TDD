package com.mehmetpekdemir.categoryservice.common.rest;

import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public class BaseController {

    protected <T> Response<DataResponse<T>> respond(List<T> data) {
        return ResponseBuilder.build(data);
    }

    protected <T> Response<DataResponse<T>> respond(List<T> data, MetaResponse meta) {
        return ResponseBuilder.build(data, meta);
    }

    protected <T> Response<T> respond(T data) {
        return ResponseBuilder.build(data);
    }

    protected Response<ErrorResponse> respond(ErrorResponse errorResponse) {
        return ResponseBuilder.build(errorResponse);
    }

}