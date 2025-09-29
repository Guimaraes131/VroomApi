package io.github.Guimaraes131.VroomApi.controller.mapper;

import io.github.Guimaraes131.VroomApi.controller.dto.GetTagDTO;
import io.github.Guimaraes131.VroomApi.controller.dto.PostTagDTO;
import io.github.Guimaraes131.VroomApi.model.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TagMapper {

    Tag toEntity(PostTagDTO dto);

    @Mapping(target = "motorcycleId", expression = "java(entity.getMotorcycle() != null ? entity.getMotorcycle().getId() : null)")
    GetTagDTO toDTO(Tag entity);
}
