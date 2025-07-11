package io.github.Guimaraes131.VroomApi.repository;

import io.github.Guimaraes131.VroomApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByLogin(String login);
}
