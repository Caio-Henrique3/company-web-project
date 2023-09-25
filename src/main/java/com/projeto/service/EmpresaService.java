package com.projeto.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.projeto.model.Empresa;
import com.projeto.repository.EmpresaRepository;
import com.projeto.util.Transacional;

public class EmpresaService implements Serializable {

	private static final long serialVersionUID = -7881219353802153811L;

	@Inject
    private EmpresaRepository empresaRepository;

    @Transacional
    public void salvar(Empresa empresa) {
        empresaRepository.salvar(empresa);
    }

    @Transacional
    public void excluir(Empresa empresa) {
        empresaRepository.remover(empresa);
    }

}
