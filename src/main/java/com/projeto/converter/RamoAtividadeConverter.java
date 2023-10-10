package com.projeto.converter;

import java.util.List;
import java.util.Objects;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.projeto.model.RamoAtividade;

public class RamoAtividadeConverter implements Converter {

    private List<RamoAtividade> listaRamoAtividades;

    public RamoAtividadeConverter(List<RamoAtividade> listaRamoAtividades) {
        this.listaRamoAtividades = listaRamoAtividades;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (Objects.isNull(value)) {
            return null;
        }

        Long id = Long.valueOf(value);
        for (RamoAtividade ramoAtividade: listaRamoAtividades) {
            if (id.equals(ramoAtividade.getId())) {
                return ramoAtividade;
            }
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (Objects.isNull(value)) {
            return null;
        }

        RamoAtividade ramoAtividade = (RamoAtividade) value;
        return ramoAtividade.getId().toString();
    }
}
