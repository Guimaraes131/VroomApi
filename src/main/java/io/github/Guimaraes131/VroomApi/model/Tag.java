package io.github.Guimaraes131.VroomApi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "tb_tag")
public class Tag {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String coordinate;
    private String color;

    @Column(name = "is_available")
    private boolean isAvailable;
}
