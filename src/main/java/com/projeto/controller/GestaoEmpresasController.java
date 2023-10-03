package com.projeto.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.projeto.enums.TipoEmpresa;
import com.projeto.model.Empresa;

@Named
@ViewScoped
public class GestaoEmpresasController implements Serializable {

	private static final long serialVersionUID = 3554380448381882094L;

	private Empresa empresa = new Empresa();

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}

	public void salvar() {
		System.out.println(empresa.toString());
	}

}
