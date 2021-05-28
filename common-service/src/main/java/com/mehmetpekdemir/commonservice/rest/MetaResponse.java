package com.mehmetpekdemir.commonservice.rest;

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
class MetaResponse {

    private Integer limit;
    private Integer currentPage;
    private Long total;
    private Integer totalPage;

}
