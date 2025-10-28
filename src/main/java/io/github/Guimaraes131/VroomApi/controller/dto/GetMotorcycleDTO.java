package io.github.Guimaraes131.VroomApi.controller.dto;

import io.github.Guimaraes131.VroomApi.model.enums.MotorcycleModel;
import io.github.Guimaraes131.VroomApi.model.enums.ProblemCategory;

public record GetMotorcycleDTO(
        Long id,
        String licensePlate,
        String chassis,
        String problemDescription,
        MotorcycleModel model,
        ProblemCategory problem
) {
}
