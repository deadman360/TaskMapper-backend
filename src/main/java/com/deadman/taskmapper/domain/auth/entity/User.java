package com.deadman.taskmapper.domain.auth.entity;

import com.deadman.taskmapper.domain.auth.value_object.Email;
import com.deadman.taskmapper.domain.auth.value_object.Password;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Embedded
    @Valid
    private Email email;

    @Embedded
    @Valid
    private Password password;
}
