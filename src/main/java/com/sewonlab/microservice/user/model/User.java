package com.sewonlab.microservice.user.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
@Introspected
@Serdeable
public class User {
    private int id;
    private String name;
    private String email;
    private String mobileNumber;
}
