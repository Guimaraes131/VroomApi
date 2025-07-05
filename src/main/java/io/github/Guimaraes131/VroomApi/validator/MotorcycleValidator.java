package io.github.Guimaraes131.VroomApi.validator;

import io.github.Guimaraes131.VroomApi.exception.InvalidOperationException;
import io.github.Guimaraes131.VroomApi.model.Motorcycle;
import io.github.Guimaraes131.VroomApi.repository.MotorcycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MotorcycleValidator {

    private MotorcycleRepository repository;

    public void validate(Motorcycle motorcycle) {
        if (tagIsNotAvailable(motorcycle)) {
            throw new InvalidOperationException("Cannot create or update a motorcycle with a tag that is being used.");
        }
    }

    private boolean tagIsNotAvailable(Motorcycle motorcycle) {
        return !motorcycle.getTag().getIsAvailable();
    }
}
