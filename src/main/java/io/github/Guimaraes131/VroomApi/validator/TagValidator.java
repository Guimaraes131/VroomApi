package io.github.Guimaraes131.VroomApi.validator;

import io.github.Guimaraes131.VroomApi.exception.DuplicatedRecordException;
import io.github.Guimaraes131.VroomApi.model.Tag;
import io.github.Guimaraes131.VroomApi.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TagValidator {

    private final TagRepository repository;

    public void validate(Tag tag) {
        if (tagCoordinateExists(tag.getCoordinate())) {
            throw new DuplicatedRecordException("This coordinate is already being used by another Tag.");
        }
    }

    private boolean tagCoordinateExists(String coordinate) {
        return repository.existsByCoordinate(coordinate);
    }
}
