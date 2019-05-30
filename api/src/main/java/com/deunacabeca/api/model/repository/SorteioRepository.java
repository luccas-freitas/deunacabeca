package com.deunacabeca.api.model.repository;

import java.util.Date;

import com.deunacabeca.api.model.Sorteio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SorteioRepository extends PagingAndSortingRepository<Sorteio, Long> {
    Page<Sorteio> findByData(Date data, Pageable pageable);
}