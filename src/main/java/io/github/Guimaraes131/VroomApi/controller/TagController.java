package io.github.Guimaraes131.VroomApi.controller;

import io.github.Guimaraes131.VroomApi.controller.dto.GetTagDTO;
import io.github.Guimaraes131.VroomApi.controller.dto.PostTagDTO;
import io.github.Guimaraes131.VroomApi.controller.mapper.TagMapper;
import io.github.Guimaraes131.VroomApi.model.Tag;
import io.github.Guimaraes131.VroomApi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<GetTagDTO> get(@PathVariable("id") String id) {
        UUID entityId = UUID.fromString(id);

        return service.get(entityId)
                .map(tag -> {
                    GetTagDTO dto = mapper.toDTO(tag);

                    return ResponseEntity.ok(dto);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        UUID entityId = UUID.fromString(id);

        return service.get(entityId)
                .map(tag -> {
                    service.delete(tag);

                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<GetTagDTO>> index(@RequestParam(value = "color", required = false) String color) {
        List<Tag> index = service.index(color);

        List<GetTagDTO> dtos = index.stream().map(mapper::toDTO).toList();

        return ResponseEntity.ok(dtos);
    }

}
