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

    private String getSoma() {
        //TODO
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Sorteio populate(SorteioCommand command) {
        Sorteio sorteio = new Sorteio();
        sorteio.setData(command.getData());
        sorteio.setHorario(command.getHorario());
        sorteio.setLoteria(command.getLoteria());

        List<Resultado> resultados = new ArrayList<>();
        for(ResultadoCommand res : command.getResultados()) {
            Resultado resultado = new Resultado();
            resultado.setValor(res.getValor());
            resultado.setAnimal(res.getAnimal());
            resultados.add(resultado);
        }
        sorteio.setResultados(resultados);

        return sorteio;
    }
}
