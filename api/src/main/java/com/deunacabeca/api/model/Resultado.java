package com.deunacabeca.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.deunacabeca.api.command.ResultadoCommand;
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

    public Resultado(ResultadoCommand command) {
        this.setValor(command.getValor());
        this.setAnimal(command.getValor());
    }

    public void setAnimal(String valor) {
        int res = Integer.parseInt(valor);
        if(res % 100 >= 1 && res % 100 <= 4)
            this.animal = "Avestruz";
        else if(res % 100 >= 5 && res % 100 <= 8)
            this.animal = "Águia";
        else if(res % 100 >= 9 && res % 100 <= 12)
            this.animal = "Burro";
        else if(res % 100 >= 13 && res % 100 <= 16)
            this.animal = "Borboleta";
        else if(res % 100 >= 17 && res % 100 <= 20)
            this.animal = "Cachorro";
        else if(res % 100 >= 21 && res % 100 <= 24)
            this.animal = "Cabra";
        else if(res % 100 >= 25 && res % 100 <= 28)
            this.animal = "Carneiro";
        else if(res % 100 >= 29 && res % 100 <= 32)
            this.animal = "Camelo";
        else if(res % 100 >= 33 && res % 100 <= 36)
            this.animal = "Cobra";
        else if(res % 100 >= 37 && res % 100 <= 40)
            this.animal = "Coelho";
        else if(res % 100 >= 41 && res % 100 <= 44)
            this.animal = "Cavalo";
        else if(res % 100 >= 45 && res % 100 <= 48)
            this.animal = "Elefante";
        else if(res % 100 >= 49 && res % 100 <= 52)
            this.animal = "Galo";
        else if(res % 100 >= 53 && res % 100 <= 56)
            this.animal = "Gato";
        else if(res % 100 >= 57 && res % 100 <= 60)
            this.animal = "Jacaré";
        else if(res % 100 >= 61 && res % 100 <= 64)
            this.animal = "Leão";
        else if(res % 100 >= 65 && res % 100 <= 68)
            this.animal = "Macaco";
        else if(res % 100 >= 69 && res % 100 <= 72)
            this.animal = "Porco";
        else if(res % 100 >= 73 && res % 100 <= 76)
            this.animal = "Pavão";
        else if(res % 100 >= 77 && res % 100 <= 80)
            this.animal = "Peru";
        else if(res % 100 >= 81 && res % 100 <= 84)
            this.animal = "Touro";
        else if(res % 100 >= 85 && res % 100 <= 88)
            this.animal = "Tigre";
        else if(res % 100 >= 89 && res % 100 <= 92)
            this.animal = "Urso";
        else if(res % 100 >= 93 && res % 100 <= 96)
            this.animal = "Veado";
        else if(res % 100 >= 97 || res % 100 == 0)
            this.animal = "Vaca";
        else
            this.animal = "";
    }
}