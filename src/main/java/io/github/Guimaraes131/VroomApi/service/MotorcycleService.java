package io.github.Guimaraes131.VroomApi.service;

import io.github.Guimaraes131.VroomApi.model.Motorcycle;
import io.github.Guimaraes131.VroomApi.model.enums.ProblemCategory;
import io.github.Guimaraes131.VroomApi.repository.MotorcycleRepository;
import io.github.Guimaraes131.VroomApi.repository.TagRepository;
import io.github.Guimaraes131.VroomApi.validator.MotorcycleValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MotorcycleService {

    private final MotorcycleRepository repository;
    private final MotorcycleValidator validator;
    private final TagRepository tagRepository;

    public void create(Motorcycle motorcycle) {
        validator.validate(motorcycle);

        motorcycle.getTag().setIsAvailable(false);
        motorcycle.getTag().setColor(motorcycle.getProblem().getAssociatedColor());

        repository.save(motorcycle);
    }

    public Optional<Motorcycle> get(UUID id) {
        return repository.findById(id);
    }

    public void delete(Motorcycle motorcycle) {
        var tag = tagRepository.findById(motorcycle.getTag().getId())
                .orElseThrow(
                        () -> new IllegalStateException("Tag não encontrada.")
                );

        tag.setIsAvailable(true);
        tag.setColor("rgb(230, 230, 230)");
        tag.setMotorcycle(null);

        repository.delete(motorcycle);
    }

    public List<Motorcycle> index(ProblemCategory problem) {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setProblem(problem);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT)
                .withIgnoreNullValues();

        Example<Motorcycle> example = Example.of(motorcycle, matcher);

        return repository.findAll(example);
    }

    public void update(Motorcycle motorcycle) {
        validator.validate(motorcycle);
        motorcycle.getTag().setColor(motorcycle.getProblem().getAssociatedColor());
        repository.save(motorcycle);
    }
}
