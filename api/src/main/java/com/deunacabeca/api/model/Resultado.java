package com.deunacabeca.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Entity
@Table(name = "RESULT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RESULT_VL")
    @NotNull(message = "O Valor deve ser informado.")
    private String valor;

    @Column(name = "RESULT_ANM")
    private String animal;

    public Resultado(@NotNull(message = "O Valor deve ser informado.") String valor, String animal) {
        this.valor = valor;
        this.animal = animal;
    }
}