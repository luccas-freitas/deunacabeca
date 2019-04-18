package com.deunacabeca.api.repository;

import java.util.Date;
import java.util.List;

import com.deunacabeca.api.model.Sorteio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SorteioRepository extends JpaRepository<Sorteio, Long> {
    List<Sorteio> findByData(Date data);
}