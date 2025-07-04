package io.github.Guimaraes131.VroomApi.controller;

import io.github.Guimaraes131.VroomApi.service.MotorcycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/motorcycle")
@RequiredArgsConstructor
public class MotorcycleController {

    private final MotorcycleService service;
}
