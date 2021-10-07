package com.example.imobiliaria.domain.service;

import com.example.imobiliaria.domain.exception.LocacaoNaoEncontradaException;
import com.example.imobiliaria.domain.exception.NegocioException;
import com.example.imobiliaria.domain.model.Alugueis;
import com.example.imobiliaria.domain.model.Locacao;
import com.example.imobiliaria.domain.repository.AlugueisRepository;
import com.example.imobiliaria.domain.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluguelService {

    @Autowired
    private AlugueisRepository repository;

    @Autowired
    private LocacaoService locacaoService;

    @Autowired
    private LocacaoRepository locacaoRepository;

    public List<Locacao> findAll() {
        List<Locacao> alugueisList = locacaoRepository.alugueisAtivos();
        return alugueisList;
    }

    public Locacao findById(Long idLocacao){
        //retorna o aluguel do id informado desde que esteja com com ativo==1
        return locacaoRepository.findByAtivoAndId(1,idLocacao)
                .orElseThrow( () -> new NegocioException("O aluguel informado nao está ativo ou id invalido"));
    }

    public void ativarLocacao(Long idLocacao){
        //metodo ativa uma locação

        Locacao locacao = locacaoRepository.findByAtivoAndId(0, idLocacao)
                .orElseThrow( () -> new NegocioException("O aluguel informado já está ativo ou id invalido")
        );

        locacao.setAtivo(1);
        locacaoService.save(locacao);
    }

    public void desativarLocacao(Long idLocacao){
        //metodo desativa uma locação

        Locacao locacao = locacaoRepository.findByAtivoAndId(1, idLocacao)
                .orElseThrow( () -> new NegocioException("O aluguel informado nao está ativo ou id invalido")
                );

        locacao.setAtivo(0);
        locacaoService.save(locacao);
    }

}
