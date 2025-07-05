package io.github.Guimaraes131.VroomApi.service;

import io.github.Guimaraes131.VroomApi.model.Motorcycle;
import io.github.Guimaraes131.VroomApi.model.enums.ProblemCategory;
import io.github.Guimaraes131.VroomApi.repository.MotorcycleRepository;
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

    public void create(Motorcycle motorcycle) {
        repository.save(motorcycle);
    }

    public Optional<Motorcycle> get(UUID id) {
        return repository.findById(id);
    }

    public void delete(Motorcycle motorcycle) {
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
        repository.save(motorcycle);
    }
}
