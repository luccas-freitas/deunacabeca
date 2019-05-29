package com.deunacabeca.api.model.filter;

import java.util.Date;

public class SorteioFilter extends AbstractFilter {
    private String loteria;
    private String horario;
    private Date data;

    public String getLoteria() {
        return loteria;
    }

    public void setLoteria(String loteria) {
        this.loteria = loteria;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
