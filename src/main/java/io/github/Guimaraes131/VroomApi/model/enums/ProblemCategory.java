package io.github.Guimaraes131.VroomApi.model.enums;

import lombok.Getter;

@Getter
public enum ProblemCategory {
    MECHANICAL("rgb(255, 0, 0)"),
    ELECTRICAL("rgb(0, 0, 255)"),
    DOCUMENTATION("rgb(0, 255, 0)"),
    AESTHETIC("rgb(255, 255, 0)"),
    SAFETY("rgb(255, 165, 0)"),
    MULTIPLE("rgb(255, 192, 203)"),
    COMPLIANT("rgb(255, 255, 255)");

    // We'll use the RGB later to change the color of the TAG's LED.

    private final String associatedColor;

    ProblemCategory(String color) {
        this.associatedColor = color;
    }

}
