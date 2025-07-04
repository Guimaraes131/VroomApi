package io.github.Guimaraes131.VroomApi.service;

import io.github.Guimaraes131.VroomApi.model.Tag;
import io.github.Guimaraes131.VroomApi.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository repository;

    public void create(Tag tag) {
        repository.save(tag);
    }
}
