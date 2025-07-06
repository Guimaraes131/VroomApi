package io.github.Guimaraes131.VroomApi.controller.dto;

import io.github.Guimaraes131.VroomApi.model.enums.MotorcycleModel;
import io.github.Guimaraes131.VroomApi.model.enums.ProblemCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record PostMotorcycleDTO(
        @NotBlank(message = "field cannot be null or blank.")
        @Size(min = 7, max = 7, message = "field needs to have exactly 7 characters.")
        String licensePlate,

        @NotBlank(message = "field cannot be null or blank.")
        @Size(min = 17, max = 17, message = "field needs to have exactly 17 characters.")
        String chassis,

        String problemDescription,

        @NotNull(message = "field cannot be null")
        MotorcycleModel model,

        @NotNull(message = "field cannot be null")
        ProblemCategory problem,

        @NotNull(message = "field cannot be null")
        UUID tagId) {
}
