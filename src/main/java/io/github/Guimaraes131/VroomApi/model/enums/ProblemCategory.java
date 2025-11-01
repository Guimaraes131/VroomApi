package io.github.Guimaraes131.VroomApi.model.enums;

import lombok.Getter;

@Getter
public enum ProblemCategory {
    MECHANICAL("rgb(255, 0, 0)"),
    ELECTRICAL("rgb(0, 0, 255)"),
    DOCUMENTATION("rgb(0, 255, 0)"),
    AESTHETIC("rgb(255, 255, 0)"),
    SAFETY("rgb(255, 50, 0)"),
    MULTIPLE("rgb(150, 0, 0)"),
    COMPLIANT("rgb(130, 0, 255)");

    private final String associatedColor;

    ProblemCategory(String color) {
        this.associatedColor = color;
    }

}
