package io.github.Guimaraes131.VroomApi.model;

import io.github.Guimaraes131.VroomApi.model.enums.ProblemCategory;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "tb_sector")
public class Sector {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Column(name = "related_problem")
    private ProblemCategory relatedProblem;
}
