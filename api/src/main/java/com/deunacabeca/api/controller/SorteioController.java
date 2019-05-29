package com.deunacabeca.api.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.deunacabeca.api.controller.exception.DataNotFoundException;
import com.deunacabeca.api.controller.exception.SorteioNotFoundException;
import com.deunacabeca.api.model.Sorteio;
import com.deunacabeca.api.repository.SorteioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin
public class SorteioController {
    @Autowired
    private final SorteioRepository repository;

    @GetMapping(value = "/sorteios")
    public List<Sorteio> all() {
        return repository.findAll();
    }

    @GetMapping(value = "/sorteios/{id}")
    Sorteio one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new SorteioNotFoundException(id));
    }

    @GetMapping(value = "sorteios/data/{data}")
    public List<Sorteio> findByData(@PathVariable String data) throws DataNotFoundException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateParsed = null;
        try {
            dateParsed = dateFormat.parse(data);
        } catch(ParseException e) {
            throw new DataNotFoundException(data);
        }
        
        return repository.findByData(dateParsed);
    }

    @PostMapping(value = "/sorteios")
    public Sorteio newSorteio(@RequestBody Sorteio sorteio) {
        return repository.save(new Sorteio(
                sorteio.getId(), 
                sorteio.getResultados(),
                sorteio.getSoma(), 
                sorteio.getLoteria(), 
                sorteio.getHorario(),
                sorteio.getData())
            );
    }

    @PutMapping(value = "/sorteios/{id}")
    public Sorteio replaceSorteio(@PathVariable Long id, @RequestBody Sorteio newSorteio) {
        return repository.findById(id).map(
            sorteio -> {
                sorteio.setResultados(newSorteio.getResultados());
                sorteio.setSoma(newSorteio.getSoma());
                sorteio.setLoteria(newSorteio.getLoteria());
                sorteio.setHorario(newSorteio.getHorario());
                sorteio.setData(newSorteio.getData());

                return repository.save(sorteio);
            }
        )
        .orElseGet(() ->{
            newSorteio.setId(id);
            return repository.save(newSorteio);
        });
    }
    
    @DeleteMapping(value = "/sorteios/{id}")
    void deleteSorteio(@PathVariable Long id) {
        repository.deleteById(id);
    }

}