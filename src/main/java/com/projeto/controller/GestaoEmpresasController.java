package com.projeto.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.projeto.model.Empresa;
import com.projeto.repository.EmpresaRepository;

import lombok.Getter;

@Named
@ViewScoped
@Getter
public class GestaoEmpresasController implements Serializable {

	private static final long serialVersionUID = 3554380448381882094L;

	@Inject
	private EmpresaRepository empresaRepository;

	private List<Empresa> listaEmpresas;

	public void obterEmpresas() {
		this.listaEmpresas = empresaRepository.obterEmpresas();
	}

}
