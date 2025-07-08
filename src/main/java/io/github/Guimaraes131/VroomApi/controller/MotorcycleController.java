package io.github.Guimaraes131.VroomApi.controller;

import io.github.Guimaraes131.VroomApi.controller.dto.GetMotorcycleDTO;
import io.github.Guimaraes131.VroomApi.controller.dto.PostMotorcycleDTO;
import io.github.Guimaraes131.VroomApi.controller.mapper.MotorcycleMapper;
import io.github.Guimaraes131.VroomApi.model.Motorcycle;
import io.github.Guimaraes131.VroomApi.model.enums.ProblemCategory;
import io.github.Guimaraes131.VroomApi.service.MotorcycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/motorcycle")
@RequiredArgsConstructor
public class MotorcycleController implements GenericController {

    private final MotorcycleService service;
    private final MotorcycleMapper mapper;

    @PostMapping
    @PreAuthorize("hasAnyRole('MANAGER', 'OPERATOR')")
    public ResponseEntity<Void> create(@RequestBody PostMotorcycleDTO dto) {
        Motorcycle entity = mapper.toEntity(dto);
        service.create(entity);

        return ResponseEntity.created(generateHeaderLocation(entity.getId())).build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('MANAGER', 'OPERATOR')")
    public ResponseEntity<GetMotorcycleDTO> get(@PathVariable("id") String id) {
        UUID uuid = UUID.fromString(id);

        return service.get(uuid)
                .map(entity -> {
                    GetMotorcycleDTO dto = mapper.toDTO(entity);

                    return ResponseEntity.ok(dto);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('MANAGER', 'OPERATOR')")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        UUID uuid = UUID.fromString(id);

        return service.get(uuid)
                .map(entity -> {
                    service.delete(entity);

                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('MANAGER', 'OPERATOR')")
    public ResponseEntity<List<GetMotorcycleDTO>> index(
            @RequestParam(required = false, value = "problem") ProblemCategory problem) {

        List<Motorcycle> index = service.index(problem);

        List<GetMotorcycleDTO> dtos = index.stream()
                .map(mapper::toDTO)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('MANAGER', 'OPERATOR')")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody PostMotorcycleDTO dto) {
        UUID uuid = UUID.fromString(id);

        return service.get(uuid)
                .map(entity -> {
                    mapper.updateFromDTO(dto, entity);

                    service.update(entity);

                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
