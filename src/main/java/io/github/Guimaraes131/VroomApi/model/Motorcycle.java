package io.github.Guimaraes131.VroomApi.model;

import io.github.Guimaraes131.VroomApi.model.enums.MotorcycleModel;
import io.github.Guimaraes131.VroomApi.model.enums.ProblemCategory;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "tb_motorcycle")
public class Motorcycle {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "license_plate")
    private String licensePlate;

    private String chassis;

    @Column(name = "problem_description")
    private String problemDescription;

    private MotorcycleModel model;
    private ProblemCategory problem;

    @OneToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;
}
