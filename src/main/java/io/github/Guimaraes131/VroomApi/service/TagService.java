package io.github.Guimaraes131.VroomApi.service;

import io.github.Guimaraes131.VroomApi.model.Tag;
import io.github.Guimaraes131.VroomApi.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository repository;

    public void create(Tag tag) {
        repository.save(tag);
    }

    public Optional<Tag> get(UUID id) {
        return repository.findById(id);
    }

    public void delete(Tag tag) {
        repository.delete(tag);
    }
}
