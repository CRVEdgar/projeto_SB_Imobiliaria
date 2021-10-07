package com.example.imobiliaria.domain.repository;

import com.example.imobiliaria.domain.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    @Query("from Locacao l where l.ativo = 1")
    List<Locacao> alugueisAtivos();

    Optional<Locacao> findByAtivoAndId(int ativo, Long id);

    Optional<Locacao> findByAtivo(int ativo);
}
