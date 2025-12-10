package com.sewonlab.microservice.user.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
@Introspected
@Serdeable
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @NotBlank
    @Column
    private String name;
    @NotBlank
    @Column
    private String email;
    @NotBlank
    @Column
    private String mobileNumber;
}
