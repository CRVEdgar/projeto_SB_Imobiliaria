package com.example.imobiliaria.api.model.input;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
public class ClienteInput {

    @NotBlank
    private String nome;

    @CPF
    private String cpf;

    private String telefone;

    @Email
    private String email;

    @Temporal(TemporalType.DATE)
    private Date dt_nascimento;
}
