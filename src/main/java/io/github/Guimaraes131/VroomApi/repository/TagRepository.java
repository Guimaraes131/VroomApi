package io.github.Guimaraes131.VroomApi.repository;

import io.github.Guimaraes131.VroomApi.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {

    boolean existsByCoordinate(String coordinate);
    List<Tag> findAllByOrderByCoordinateAsc();
}
