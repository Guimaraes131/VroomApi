package io.github.Guimaraes131.VroomApi.controller;

import io.github.Guimaraes131.VroomApi.controller.dto.PostTagDTO;
import io.github.Guimaraes131.VroomApi.controller.mapper.TagMapper;
import io.github.Guimaraes131.VroomApi.model.Tag;
import io.github.Guimaraes131.VroomApi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService service;
    private final TagMapper mapper;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PostTagDTO dto) {
        Tag entity = mapper.toEntity(dto);

        service.create(entity);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
