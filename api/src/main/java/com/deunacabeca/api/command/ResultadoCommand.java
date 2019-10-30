package com.deunacabeca.api.command;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResultadoCommand extends AbstractCommand {
    private String valor;
    private String animal;
}
