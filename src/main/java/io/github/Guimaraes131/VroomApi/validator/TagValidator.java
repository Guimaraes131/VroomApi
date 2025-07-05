package io.github.Guimaraes131.VroomApi.validator;

import io.github.Guimaraes131.VroomApi.exception.DuplicatedRecordException;
import io.github.Guimaraes131.VroomApi.exception.InvalidOperationException;
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

        if (tagIsNotAvailable(tag) && tag.getColor() == null) {
            throw new InvalidOperationException("A tag that is not available needs to have a color.");
        }
    }

    private boolean tagCoordinateExists(String coordinate) {
        return repository.existsByCoordinate(coordinate);
    }

    private boolean tagIsNotAvailable(Tag tag) {
        return !tag.getIsAvailable();
    }
}
