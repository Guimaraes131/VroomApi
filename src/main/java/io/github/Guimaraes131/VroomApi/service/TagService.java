package io.github.Guimaraes131.VroomApi.service;

import io.github.Guimaraes131.VroomApi.model.Tag;
import io.github.Guimaraes131.VroomApi.repository.TagRepository;
import io.github.Guimaraes131.VroomApi.validator.TagValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository repository;
    private final TagValidator validator;

    public void create(Tag tag) {
        validator.validate(tag);
        repository.save(tag);
    }

    public Optional<Tag> get(UUID id) {
        return repository.findById(id);
    }

    public void delete(Tag tag) {
        repository.delete(tag);
    }

    public List<Tag> index(String color) {
        Tag tag = new Tag();
        tag.setColor(color);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT);

        Example<Tag> example = Example.of(tag, matcher);

        return repository.findAll(example);
    }
}
