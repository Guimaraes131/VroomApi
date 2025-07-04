package io.github.Guimaraes131.VroomApi.service;

import io.github.Guimaraes131.VroomApi.repository.MotorcycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MotorcycleService {

    private final MotorcycleRepository repository;
}
