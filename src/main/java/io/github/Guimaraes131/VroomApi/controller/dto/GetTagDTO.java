package io.github.Guimaraes131.VroomApi.controller.dto;

import java.util.UUID;

public record GetTagDTO(
        UUID id,
        String coordinate,
        String color,
        Boolean isAvailable) {
}
