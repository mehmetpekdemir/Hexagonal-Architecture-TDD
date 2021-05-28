package com.mehmetpekdemir.categoryservice.application.port.in.command;

import lombok.Getter;
import lombok.Setter;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@Setter
public final class CreateCategoryCommand {

    private String name;

}
