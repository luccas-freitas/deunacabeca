package com.deunacabeca.api.model.repository;

import com.deunacabeca.api.model.Sorteio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SorteioRepository extends JpaRepository<Sorteio, Long> {
    List<Sorteio> findByDataOrderByDataAsc(Date data);
}