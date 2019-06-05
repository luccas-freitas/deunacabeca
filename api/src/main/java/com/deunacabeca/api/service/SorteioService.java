package com.deunacabeca.api.service;

import com.deunacabeca.api.controller.exception.InvalidFormatException;
import com.deunacabeca.api.controller.exception.NotFoundException;
import com.deunacabeca.api.model.Sorteio;
import com.deunacabeca.api.model.repository.SorteioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SorteioService {
    private final SorteioRepository repository;

    @Autowired
    public SorteioService(SorteioRepository repository) {
        this.repository = repository;
    }

    public List<Sorteio> all() {
        return repository.findAll();
    }

    public Optional<Sorteio> one(String id) {
        Long _id = new Long(id);

        _id = Long.parseLong(id);
        if (!repository.findById(_id).isPresent())
            throw new NotFoundException("Sorteio " + id + " não encontrado.");

        return repository.findById(_id);
    }

    public List<Sorteio> findByData(String data) throws InvalidFormatException {
        List<Sorteio> list = new ArrayList<>();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date dateParsed = dateFormat.parse(data);
            list = repository.findByData(dateParsed);
            if (list.isEmpty())
                throw new NotFoundException("Não há lançamentos para a data " + data);

        } catch (ParseException e) {
            throw new InvalidFormatException("Formato de data " + data + " inválido.");
        }

        return list;
    }

    public Sorteio newSorteio(Sorteio sorteio) {
        return repository.save(new Sorteio(sorteio.getId(), sorteio.getResultados(), sorteio.getSoma(),
                sorteio.getConcurso(), sorteio.getLoteria(), sorteio.getHorario(), sorteio.getData()));
    }

    public Optional<Sorteio> replaceSorteio(Long id, Sorteio newSorteio) {
        if (!repository.findById(id).isPresent())
            throw new NotFoundException("Sorteio " + id + " não encontrado.");

        return repository.findById(id).map(sorteio -> {
            sorteio.setResultados(newSorteio.getResultados());
            sorteio.setSoma(newSorteio.getSoma());
            sorteio.setConcurso(newSorteio.getConcurso());
            sorteio.setLoteria(newSorteio.getLoteria());
            sorteio.setHorario(newSorteio.getHorario());
            sorteio.setData(newSorteio.getData());

            return repository.save(sorteio);
        });
    }

    public void deleteSorteio(Long id) {
        repository.deleteById(id);
    }
}
