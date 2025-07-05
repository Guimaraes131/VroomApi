package io.github.Guimaraes131.VroomApi.controller.mapper;

import io.github.Guimaraes131.VroomApi.controller.dto.GetMotorcycleDTO;
import io.github.Guimaraes131.VroomApi.controller.dto.PostMotorcycleDTO;
import io.github.Guimaraes131.VroomApi.model.Motorcycle;
import io.github.Guimaraes131.VroomApi.repository.TagRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = TagMapper.class)
public abstract class MotorcycleMapper {

    @Autowired
    TagRepository repository;

    @Mapping(target = "tag", expression = "java( repository.findById(dto.tagId()).orElse(null) )")
    public abstract Motorcycle toEntity(PostMotorcycleDTO dto);

    public abstract GetMotorcycleDTO toDTO(Motorcycle entity);

    @Mapping(target = "id", ignore = true)
    public abstract void updateFromDTO(PostMotorcycleDTO dto, @MappingTarget Motorcycle entity);
}
