package io.github.Guimaraes131.VroomApi.controller.mapper;

import io.github.Guimaraes131.VroomApi.controller.dto.GetTagDTO;
import io.github.Guimaraes131.VroomApi.controller.dto.PostTagDTO;
import io.github.Guimaraes131.VroomApi.model.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {

    Tag toEntity(PostTagDTO dto);

    GetTagDTO toDTO(Tag entity);
}
