package io.github.Guimaraes131.VroomApi.controller.dto;

import jakarta.validation.constraints.*;

public record PostTagDTO(
        @NotBlank(message = "field cannot be null or blank")
        @Size(min = 3, max = 3, message = "field needs to have 3 characters")
        String coordinate,

        @Pattern(regexp = "^RGB\\(\\s*([0-9]{1,3})\\s*,\\s*([0-9]{1,3})\\s*,\\s*([0-9]{1,3})\\s*\\)$",
                message = "Invalid format.")
        @Size(min = 13, max = 18, message = "field needs to have between 13 to 18 characters.")
        String color,

        @NotNull(message = "field cannot be null")
        Boolean isAvailable) {
}
