package com.mehmetpekdemir.categoryservice.adapter.in.web.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@Setter
public final class CreateCategoryRequest {

    @NotBlank
    private String name;

}
