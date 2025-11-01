CREATE TABLE tb_motorcycle(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    license_plate VARCHAR(255) UNIQUE,
    chassis VARCHAR(255) UNIQUE,
    problem_description VARCHAR(255),
    model VARCHAR(12),
    problem VARCHAR(15),
    tag_id BIGINT NOT NULL REFERENCES tb_tag(id),
    CONSTRAINT chk_model CHECK (model in ('MOTTUPOP', 'MOTTUSPORT', 'MOTTUE')),
    CONSTRAINT chk_problem CHECK (problem in ('MECHANICAL', 'ELECTRICAL', 'DOCUMENTATION', 'AESTHETIC', 'SAFETY', 'MULTIPLE', 'COMPLIANT'))
);