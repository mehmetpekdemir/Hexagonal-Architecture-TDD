package com.mehmetpekdemir.categoryservice.application.port.in.command;

import lombok.Builder;
import lombok.Getter;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@Builder
public final class CreateCategoryCommand {

    private final String parentId;
    private final String name;
    private final String description;
    private final String status;

}
