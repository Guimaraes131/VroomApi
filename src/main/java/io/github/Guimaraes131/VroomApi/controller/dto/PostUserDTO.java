package io.github.Guimaraes131.VroomApi.controller.dto;

import java.util.List;

public record PostUserDTO(String login, String password, List<String> roles) {
}
