package com.deunacabeca.api.controller;

import com.deunacabeca.api.command.SorteioCommand;
import com.deunacabeca.api.controller.exception.InvalidFormatException;
import com.deunacabeca.api.service.SorteioService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin
public class SorteioController {
    private final SorteioService service;

    @GetMapping(value = "/sorteios")
    public ResponseEntity<?> all() {
        return ResponseEntity.ok(service.all());
    }

    @GetMapping(value = "/sorteios/{id}")
    public ResponseEntity<?> one(@PathVariable Long id) {
        return service.one(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "sorteios/data/{data}")
    public ResponseEntity<?> findByData(@PathVariable String data) throws InvalidFormatException {
        SorteioCommand command = new SorteioCommand();
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            command.setData(format.parse(data));
        } catch (ParseException e) {
            throw new InvalidFormatException("Formato de data inválido.");
        }

        return ResponseEntity.ok(service.findByData(command));
    }

    @PostMapping(value = "/sorteios")
    public ResponseEntity<?> create(@RequestBody SorteioCommand command) {
        return ResponseEntity.ok(service.create(command));
    }

    @PutMapping(value = "/sorteios/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SorteioCommand command) {
        return service.one(id)
                .map(record -> ResponseEntity.ok().body(service.update(id, command)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/sorteios/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}