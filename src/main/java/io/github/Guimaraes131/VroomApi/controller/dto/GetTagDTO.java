package io.github.Guimaraes131.VroomApi.controller.dto;

public record GetTagDTO(
        Long id,
        String coordinate,
        String color,
        Boolean isAvailable,
        Long motorcycleId) {
}
