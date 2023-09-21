package com.projeto.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.projeto.model.Empresa;

public class EmpresaRepository implements Serializable {

	private static final long serialVersionUID = -149372040002060236L;

	private EntityManager manager;

	public EmpresaRepository() {

	}

	public EmpresaRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Empresa obterPorId(Long id) {
		return manager.find(Empresa.class, id);
	}

	public List<Empresa> obterPorNome(String nome) {
		return manager.createQuery("FROM Empresa "
								 + "WHERE nomeFantasia LIKE :nomeFantasia", Empresa.class)
				.setParameter("nomeFantasia", nome + "%")
				.getResultList();
	}

	public Empresa salvar(Empresa empresa) {
		return manager.merge(empresa);
	}

	public void remover(Empresa empresa) {
		empresa = obterPorId(empresa.getId());
		manager.remove(empresa);
	}

}
