package com.deunacabeca.api.command;

import com.deunacabeca.api.util.HorarioEnum;
import com.deunacabeca.api.util.LoteriaEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode
@Data
public class SorteioCommand {
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date data;
    private HorarioEnum horario;
    private LoteriaEnum loteria;
    private List<ResultadoCommand> resultados;
}
