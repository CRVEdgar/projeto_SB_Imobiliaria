package com.example.imobiliaria.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tab_alugueis")
public class Alugueis {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dt_vencimento;

    private Double valor_pago;
    private String obs;

    @ManyToOne
    @JoinColumn(name = "id_locacao")
    private Locacao locacao;
}
