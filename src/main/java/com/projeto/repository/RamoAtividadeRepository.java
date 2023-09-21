package com.projeto.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.projeto.model.RamoAtividade;

public class RamoAtividadeRepository implements Serializable {

	private static final long serialVersionUID = -149372040002060236L;

	private EntityManager manager;

	public RamoAtividadeRepository() {

	}

	public RamoAtividadeRepository(EntityManager manager) {
		this.manager = manager;
	}

	public RamoAtividade obterPorId(Long id) {
		return manager.find(RamoAtividade.class, id);
	}

	public List<RamoAtividade> obterPorDescricao(String descricao) {
		return manager.createQuery("FROM RamoAtividade "
								 + "WHERE descricao LIKE :descricao", RamoAtividade.class)
				.setParameter("descricao", descricao + "%")
				.getResultList();
	}

	public RamoAtividade salvar(RamoAtividade ramoAtividade) {
		return manager.merge(ramoAtividade);
	}

	public void remover(RamoAtividade ramoAtividade) {
		ramoAtividade = obterPorId(ramoAtividade.getId());
		manager.remove(ramoAtividade);
	}

}
