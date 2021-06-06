package com.mehmetpekdemir.categoryservice.common.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse<T> {

    private List<T> data = List.of();
    private MetaResponse meta;

    public DataResponse(List<T> data) {
        this.data = data;
    }

}
