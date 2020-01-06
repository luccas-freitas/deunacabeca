package com.deunacabeca.api.util;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@AllArgsConstructor
public enum LoteriaEnum {
    PTRIO("PT-RIO"),
    PR("PR"),
    FEDERAL("FEDERAL"),
    MEGASENA("MEGA SENA"),
    QUINABR("QUINA BR");

    @Getter
    String loteria;

    @JsonValue
    @Override
    public String toString() {
        return this.loteria;
    }

    @Converter(autoApply = true)
    public static class Mapper implements AttributeConverter<LoteriaEnum, String> {
        @Override
        public String convertToDatabaseColumn(LoteriaEnum loteria) {
            return String.valueOf(loteria.getLoteria());
        }

        @Override
        public LoteriaEnum convertToEntityAttribute(String loteria) {
            if(loteria == null)             return null;
            if("PT-RIO".equals(loteria))    return PTRIO;
            if("PR".equals(loteria))        return PR;
            if("FEDERAL".equals(loteria))   return FEDERAL;
            if("MEGA SENA".equals(loteria)) return MEGASENA;
            if("QUINA BR".equals(loteria))  return QUINABR;

            throw new IllegalStateException("Loteria inválida:" + loteria);
        }
    }
    
}