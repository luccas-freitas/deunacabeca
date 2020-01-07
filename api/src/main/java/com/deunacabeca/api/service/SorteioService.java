package com.deunacabeca.api.service;

import com.deunacabeca.api.command.ResultadoCommand;
import com.deunacabeca.api.command.SorteioCommand;
import com.deunacabeca.api.model.Resultado;
import com.deunacabeca.api.model.Sorteio;
import com.deunacabeca.api.model.repository.SorteioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Sorteio> all() {
        return repository.findAll();
    }

    public Optional<Sorteio> one(Long id) {
        return repository.findById(id);
    }

    public List<Sorteio> findByData(SorteioCommand command) {
        return repository.findByDataOrderByDataAsc(command.getData());
    }

    public Sorteio create(SorteioCommand command) {
        return repository.save(populate(command));
    }

    public Sorteio update(Long id, SorteioCommand command) {
        Sorteio sorteio = populate(command);
        sorteio.setId(id);
        return repository.save(sorteio);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Sorteio populate(SorteioCommand command) {
        List<Resultado> resultados = new ArrayList<>();
        for(ResultadoCommand res : command.getResultados()) {
            Resultado resultado = new Resultado(res);
            resultados.add(resultado);
        }

        return new Sorteio(command, resultados);
    }
}
