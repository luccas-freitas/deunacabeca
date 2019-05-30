package com.deunacabeca.api.service;

import com.deunacabeca.api.controller.exception.DataInvalidFormatException;
import com.deunacabeca.api.controller.exception.DataNotFoundException;
import com.deunacabeca.api.controller.exception.SorteioNotFoundException;
import com.deunacabeca.api.model.Sorteio;
import com.deunacabeca.api.model.filter.SorteioFilter;
import com.deunacabeca.api.model.repository.SorteioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class SorteioService {
    private final SorteioRepository repository;

    @Autowired
    public SorteioService(SorteioRepository repository) {
        this.repository = repository;
    }

    public Page<Sorteio> all(SorteioFilter filter) {
        Pageable pageable = PageRequest.of(filter.getPage(), filter.getQuantity(), Sort.by("createdAt").ascending());

        return repository.findAll(pageable);
    }

    public Optional<Sorteio> one(Long id) {
        if(!repository.findById(id).isPresent())
            throw  new SorteioNotFoundException(id);

        return repository.findById(id);
    }

    public Page<Sorteio> findByData(SorteioFilter filter, String data) throws DataInvalidFormatException {
        Pageable pageable = PageRequest.of(filter.getPage(), filter.getQuantity(), Sort.by("createdAt").ascending());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateParsed;

        try {
            dateParsed = dateFormat.parse(data);
        } catch(ParseException e) {
            throw new DataInvalidFormatException(data);
        }

        Page<Sorteio> page = repository.findByData(dateParsed, pageable);
        if(page.isEmpty())
            throw new DataNotFoundException(data);

        return page;
    }

    public Sorteio newSorteio(Sorteio sorteio) {
        return repository.save(new Sorteio(
                sorteio.getId(),
                sorteio.getResultados(),
                sorteio.getSoma(),
                sorteio.getLoteria(),
                sorteio.getHorario(),
                sorteio.getData())
        );
    }

    public Optional<Sorteio> replaceSorteio(Long id, Sorteio newSorteio) {
        if(!repository.findById(id).isPresent())
            throw new SorteioNotFoundException(id);

        return repository.findById(id).map(
                sorteio -> {
                    sorteio.setResultados(newSorteio.getResultados());
                    sorteio.setSoma(newSorteio.getSoma());
                    sorteio.setLoteria(newSorteio.getLoteria());
                    sorteio.setHorario(newSorteio.getHorario());
                    sorteio.setData(newSorteio.getData());

                    return repository.save(sorteio);
                }
        );
    }

    public void deleteSorteio(Long id) {
        repository.deleteById(id);
    }
}
