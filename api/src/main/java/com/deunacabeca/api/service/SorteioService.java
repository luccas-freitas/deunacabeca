package com.deunacabeca.api.service;

import com.deunacabeca.api.command.ResultadoCommand;
import com.deunacabeca.api.command.SorteioCommand;
import com.deunacabeca.api.controller.exception.NotFoundException;
import com.deunacabeca.api.model.Resultado;
import com.deunacabeca.api.model.Sorteio;
import com.deunacabeca.api.model.repository.SorteioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SorteioService {
    private final SorteioRepository repository;

    @Autowired
    public SorteioService(SorteioRepository repository) {
        this.repository = repository;
    }

    public Page<Sorteio> all(SorteioCommand command) {
        Pageable pageable = PageRequest.of(command.getPage(), command.getSize(), Sort.by("data").ascending());
        return repository.findAll(pageable);
    }

    public Optional<Sorteio> one(Long id) {
        if (!repository.findById(id).isPresent())
            throw new NotFoundException("Sorteio " + id + " não encontrado.");
        return repository.findById(id);
    }

    public Page<Sorteio> findByData(SorteioCommand command) {
        Pageable pageable = PageRequest.of(command.getPage(), command.getSize(), Sort.by("data").ascending());
        return repository.findByData(command.getData(), pageable);
    }

    public Sorteio create(SorteioCommand sorteioCommand, List<ResultadoCommand> resultadosCommand) {
        Sorteio sorteio = new Sorteio();
        sorteio.setLoteria(sorteioCommand.getLoteria());
        sorteio.setHorario(sorteioCommand.getHorario());
        sorteio.setData(sorteioCommand.getData());

        List<Resultado> resultados = new ArrayList<>();
        for (ResultadoCommand command : resultadosCommand) {
            resultados.add(new Resultado(command.getValor(), command.getAnimal()));
        }
        sorteio.setResultados(resultados);
        sorteio.setSoma(this.getSoma());

        return repository.save(sorteio);
    }

    private String getSoma() {
        //TODO
        return null;
    }

    public Optional<Sorteio> update(Long id, SorteioCommand sorteioCommand, List<ResultadoCommand> resultadosCommand) {
        if (!repository.findById(id).isPresent())
            throw new NotFoundException("Sorteio " + id + " não encontrado.");

        return repository.findById(id).map(sorteio -> create(sorteioCommand, resultadosCommand));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
