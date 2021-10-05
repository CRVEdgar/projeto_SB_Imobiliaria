package com.example.imobiliaria.api.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImovelInput {

    private String tipo_Imovel;
    private String endereco;
    private String cep;
    private Integer dormitorios;
    private Integer banheiros;
    private Integer suites;
    private Integer metragem;
    private Double valor_aluguel_suge;
    private String obs;
}
