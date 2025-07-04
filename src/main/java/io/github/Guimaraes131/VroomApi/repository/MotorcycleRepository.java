package io.github.Guimaraes131.VroomApi.repository;

import io.github.Guimaraes131.VroomApi.model.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, UUID> {
}
