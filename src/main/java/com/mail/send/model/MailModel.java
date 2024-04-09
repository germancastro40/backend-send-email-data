package com.mail.send.model;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class MailModel {
    @NotEmpty(message = "Este campo no puede ser vacio")
    @NotNull(message = "Este campo no puede ser nulo")
    String nombre;

    @Email()
    @NotEmpty(message = "Este campo no puede ser vacio")
    @NotNull(message = "Este campo no puede ser nulo")
    String email;

    @NotEmpty(message = "Este campo no puede ser vacio")
    @NotNull(message = "Este campo no puede ser nulo")
    String mensaje;

    @NotEmpty(message = "Este campo no puede ser vacio")
    @NotNull(message = "Este campo no puede ser nulo")
    String telefono;
}
