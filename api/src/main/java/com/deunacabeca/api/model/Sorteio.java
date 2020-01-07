package com.deunacabeca.api.model;

import com.deunacabeca.api.command.SorteioCommand;
import com.deunacabeca.api.util.HorarioEnum;
import com.deunacabeca.api.util.LoteriaEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "SORTEIO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sorteio extends AuditLog {
    private static final long serialVersionUID = -5025467096328370280L;

    @Id
    @Column(name = "SRT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = LoteriaEnum.Mapper.class)
    @Column(name = "SRT_LT")
    @NotNull(message = "A Loteria deve ser informada.")
    private LoteriaEnum loteria;

    @Convert(converter = HorarioEnum.Mapper.class)
    @Column(name = "SRT_HR")
    @NotNull(message = "O Horário deve ser informado.")
    private HorarioEnum horario;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name = "SRT_DATA")
    @NotNull(message = "A Data deve ser informada.")
    private Date data;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resultado> resultados;

    @Column(name = "SRT_SM")
    private String soma;

    public Sorteio(SorteioCommand command, List<Resultado> resultados) {
        this.setData(command.getData());
        this.setHorario(command.getHorario());
        this.setLoteria(command.getLoteria());
        this.setResultados(resultados);
        this.setSoma(resultados);
    }

    private void setSoma(List<Resultado> resultados) {
        if(resultados.size() >= 5) {
            int soma = 0;
            for (int i = 0; i < 5; i++) {
                soma += Integer.parseInt(resultados.get(i).getValor());
            }
            if(soma <= 99) {
                this.soma = "00" + soma;
            } else if(soma <= 999) {
                this.soma = "0" + soma;
            } else {
                this.soma = Integer.toString(soma);
            }
        } else {
            this.soma = "";
        }
    }
}