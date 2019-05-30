package com.deunacabeca.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.deunacabeca.api.util.HorarioEnum;
import com.deunacabeca.api.util.LoteriaEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sorteio extends AuditLog {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Resultado> resultados;

    private String soma;

    @Convert(converter = LoteriaEnum.Mapper.class)
    private LoteriaEnum loteria;

    @Convert(converter = HorarioEnum.Mapper.class)
    private HorarioEnum horario;

    @Temporal(TemporalType.DATE)
    private Date data;

}