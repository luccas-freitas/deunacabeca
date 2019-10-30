package com.deunacabeca.api.command;

import com.deunacabeca.api.util.HorarioEnum;
import com.deunacabeca.api.util.LoteriaEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SorteioCommand extends AbstractCommand {
    private Date data;
    private HorarioEnum horario;
    private LoteriaEnum loteria;
    private List<ResultadoCommand> resultados;
}
