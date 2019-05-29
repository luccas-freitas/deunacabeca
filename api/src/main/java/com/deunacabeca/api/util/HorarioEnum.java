package com.deunacabeca.api.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum HorarioEnum {
    ONZEVINTE("11:20"),
    QUATORZEVINTE("14:20"),
    DEZESEISVINTE("16:20"),
    DEZOITOVINTE("18:20"),
    DEZENOVE("19:00"),
    VINTEUMVINTE("21:20"); 

    @Getter
    String horario;

    @JsonValue
    @Override
    public String toString() {
        return this.horario;
    }

    @Converter(autoApply = true)
    public static class Mapper implements AttributeConverter<HorarioEnum, String> {
        @Override
        public String convertToDatabaseColumn(HorarioEnum horario) {
            return String.valueOf(horario.getHorario());
        }

        @Override
        public HorarioEnum convertToEntityAttribute(String horario) {
            if(horario == null)         return null;
            if("11:20".equals(horario)) return ONZEVINTE;
            if("14:20".equals(horario)) return QUATORZEVINTE;
            if("16:20".equals(horario)) return DEZESEISVINTE;
            if("18:20".equals(horario)) return DEZOITOVINTE;
            if("19:00".equals(horario)) return DEZENOVE;
            if("21:20".equals(horario)) return VINTEUMVINTE;
            else throw new IllegalStateException("Horário inválido:" + horario);
        }
    }
}