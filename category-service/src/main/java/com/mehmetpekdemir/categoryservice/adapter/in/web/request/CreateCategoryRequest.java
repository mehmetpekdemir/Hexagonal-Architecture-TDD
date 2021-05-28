package com.mehmetpekdemir.categoryservice.adapter.in.web.request;

import com.mehmetpekdemir.categoryservice.application.port.in.command.CreateCategoryCommand;
import lombok.Builder;
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

    public CreateCategoryCommand toModel() {
        return CreateCategoryCommand.builder()
                .name(name)
                .build();
    }

}
