package com.deunacabeca.api.controller;

import java.util.List;
import java.util.Optional;

import com.deunacabeca.api.controller.exception.InvalidFormatException;
import com.deunacabeca.api.controller.exception.NumberConvertException;
import com.deunacabeca.api.model.Sorteio;
import com.deunacabeca.api.service.SorteioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
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
@EnableAutoConfiguration
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin
public class SorteioController {
    @Autowired
    private final SorteioService service;

    @GetMapping(value = "/sorteios")
    public ResponseEntity<?> all() {
        List<Sorteio> list = service.all();

        return list.isEmpty() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(list);
    }

    @GetMapping(value = "/sorteios/{id}")
    public ResponseEntity<?> one(@PathVariable String id) {
        Optional<Sorteio> optional = service.one(id);

        return !optional.isPresent() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(optional);
    }

    @GetMapping(value = "sorteios/data/{data}")
    public ResponseEntity<?> findByData(@PathVariable String data) throws InvalidFormatException {
        List<Sorteio> list = service.findByData(data);

        return list.isEmpty() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(list);
    }

    @PostMapping(value = "/sorteios")
    public ResponseEntity<?> newSorteio(@RequestBody Sorteio sorteio) {
        Sorteio newSorteio = service.newSorteio(sorteio);

        return ResponseEntity.ok(newSorteio);
    }

    @PutMapping(value = "/sorteios/{id}")
    public ResponseEntity<?> replaceSorteio(@PathVariable Long id, @RequestBody Sorteio newSorteio) throws NumberConvertException {
        Optional<Sorteio> sorteio = service.replaceSorteio(id, newSorteio);

        return !sorteio.isPresent() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(sorteio);
    }
    
    @DeleteMapping(value = "/sorteios/{id}")
    public ResponseEntity<?> deleteSorteio(@PathVariable Long id) {
        service.deleteSorteio(id);

        return ResponseEntity.ok().build();
    }

}