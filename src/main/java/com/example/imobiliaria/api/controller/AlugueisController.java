package com.example.imobiliaria.api.controller;

import com.example.imobiliaria.api.assemblerConvert.LocacaoConvertAssembler;
import com.example.imobiliaria.api.assemblerConvert.LocacaoConvertDISAssembler;
import com.example.imobiliaria.api.model.dto.LocacaoDTO;
import com.example.imobiliaria.domain.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AlugueisController {

    @Autowired
    private AluguelService aluguelService;

    @Autowired
    private LocacaoConvertAssembler locacaoConvertAssembler;

    @Autowired
    private LocacaoConvertDISAssembler locacaoConvertDISAssembler;

    @GetMapping
    public List<LocacaoDTO> listarAlugueisAtivos() {
        return locacaoConvertAssembler.convert_Lista_para_DTO(aluguelService.findAll());
    }

    @GetMapping("/buscarativo/{aluguelId}")
    public LocacaoDTO busca_Se_AluguelAtivo(@PathVariable Long aluguelId) {
        return locacaoConvertAssembler
                .convert_para_DTO(aluguelService.findById(aluguelId));
    }

    @GetMapping("/criar/{aluguelIdCriar}")
    public void criarAluguel(@PathVariable Long aluguelIdCriar){
        aluguelService.ativarLocacao(aluguelIdCriar);
    }

    @GetMapping("/apagar/{aluguelIdDel}")
    public void apagarAluguel( @PathVariable Long aluguelIdDel){
        aluguelService.desativarLocacao(aluguelIdDel);
    }


}
