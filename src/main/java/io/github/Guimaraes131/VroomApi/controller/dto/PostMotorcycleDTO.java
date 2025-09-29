package io.github.Guimaraes131.VroomApi.controller.dto;

import io.github.Guimaraes131.VroomApi.model.enums.MotorcycleModel;
import io.github.Guimaraes131.VroomApi.model.enums.ProblemCategory;

import java.util.UUID;

public record PostMotorcycleDTO(
        String licensePlate,
        String chassis,
        String problemDescription,
        MotorcycleModel model,
        ProblemCategory problem,
        UUID tagId) {
}
