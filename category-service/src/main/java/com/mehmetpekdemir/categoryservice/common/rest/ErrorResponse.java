package com.mehmetpekdemir.categoryservice.common.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
class ErrorResponse {

    private String errorCode;
    private String errorDescription;

}
