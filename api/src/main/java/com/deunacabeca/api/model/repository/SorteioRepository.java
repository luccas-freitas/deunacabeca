package com.deunacabeca.api.model.repository;

import java.util.Date;

import com.deunacabeca.api.model.Sorteio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SorteioRepository extends JpaRepository<Sorteio, Long> {
    Page<Sorteio> findByData(Date data, Pageable pageable);
}