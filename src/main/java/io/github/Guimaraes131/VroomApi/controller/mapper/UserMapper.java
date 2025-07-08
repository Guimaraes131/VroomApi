package io.github.Guimaraes131.VroomApi.controller.mapper;

import io.github.Guimaraes131.VroomApi.controller.dto.PostUserDTO;
import io.github.Guimaraes131.VroomApi.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(PostUserDTO dto);
}
