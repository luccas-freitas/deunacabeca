package com.deunacabeca.api.model.repository;

import com.deunacabeca.api.model.Sorteio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface SorteioRepository extends PagingAndSortingRepository<Sorteio, Long> {
    Page<Sorteio> findByData(Date data, Pageable pageable);
}