package com.deunacabeca.api.command;

import com.deunacabeca.api.util.HorarioEnum;
import com.deunacabeca.api.util.LoteriaEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class SorteioCommand extends AbstractCommand {
    private LoteriaEnum loteria;
    private HorarioEnum horario;
    private Date data;
}
