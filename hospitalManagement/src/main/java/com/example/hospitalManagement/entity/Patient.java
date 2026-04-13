package com.example.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient_tbl",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_patient_email",
                        columnNames = {"email"}
                ),
                @UniqueConstraint(
                        name = "unique_patient_name_birthdate",
                        columnNames = {"name", "birthDate"}
                )
        },
        //use for the query optimisation
        indexes = {
                @Index(name="idx_patient_birth_date",columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ToString.Exclude
    private LocalDate birthDate;

    private String gender;

    private String email;
}
