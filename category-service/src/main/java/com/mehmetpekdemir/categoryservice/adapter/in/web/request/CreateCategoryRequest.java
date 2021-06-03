package com.mehmetpekdemir.categoryservice.adapter.in.web.request;

import com.mehmetpekdemir.categoryservice.application.port.in.command.CreateCategoryCommand;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@Setter
public final class CreateCategoryRequest {

    private String parentId;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String status;

    public CreateCategoryCommand convertCategoryRequestToCategoryCommand() {
        return CreateCategoryCommand.builder()
                .parentId(Optional.ofNullable(parentId).orElse(null))
                .name(name)
                .description(description)
                .status(status)
                .build();
    }

}
