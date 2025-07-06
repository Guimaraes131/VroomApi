package io.github.Guimaraes131.VroomApi.validator;

import io.github.Guimaraes131.VroomApi.exception.DuplicatedRecordException;
import io.github.Guimaraes131.VroomApi.exception.InvalidOperationException;
import io.github.Guimaraes131.VroomApi.model.Motorcycle;
import io.github.Guimaraes131.VroomApi.repository.MotorcycleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MotorcycleValidator {

    private final MotorcycleRepository repository;

    public void validate(Motorcycle motorcycle) {
        if (existsTag(motorcycle)) {
            throw new EntityNotFoundException("Tag not found.");
        }

        if (existsMotorcycle(motorcycle)) {
            throw new DuplicatedRecordException("Cannot proceed: data is already in use by another record.");
        }

        if (!tagIsAvailable(motorcycle)) {
            throw new InvalidOperationException("Cannot create or update a motorcycle with a tag that is being used.");
        }
    }

    private boolean tagIsAvailable(Motorcycle motorcycle) {
        return motorcycle.getTag().getIsAvailable();
    }

    private boolean existsMotorcycle(Motorcycle motorcycle) {
        Optional<Motorcycle> optionalMotorcycle = repository.findByLicensePlateOrChassis(
                motorcycle.getLicensePlate(), motorcycle.getChassis()
        );

        if (motorcycle.getId() == null) {
            return optionalMotorcycle.isPresent();
        }

        return optionalMotorcycle.isPresent() && !motorcycle.getId().equals(optionalMotorcycle.get().getId());
    }

    private boolean existsTag(Motorcycle motorcycle) {
        return motorcycle.getTag() == null;
    }
}
