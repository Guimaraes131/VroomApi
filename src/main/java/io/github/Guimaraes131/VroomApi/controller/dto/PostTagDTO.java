package io.github.Guimaraes131.VroomApi.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostTagDTO(
        @NotBlank(message = "field cannot be null or blank")
        @Size(min = 3, max = 3, message = "field needs to have 3 characters")
        String coordinate,
        String color,

        @NotNull(message = "field cannot be null")
        Boolean isAvailable) {
}
