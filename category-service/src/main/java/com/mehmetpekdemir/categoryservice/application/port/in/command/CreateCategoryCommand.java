package com.mehmetpekdemir.categoryservice.application.port.in.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@Setter
@Builder
public final class CreateCategoryCommand {

    private final String name;

}
