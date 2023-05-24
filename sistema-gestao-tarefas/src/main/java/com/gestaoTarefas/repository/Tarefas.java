package com.gestaoTarefas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.gestaoTarefas.model.Tarefa;

public class Tarefas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Tarefas() {
		
	}
	
	public Tarefas(EntityManager manager) {
		this.manager = manager;
	}
	
	public Tarefa porId(Long id) {
		return manager.find(Tarefa.class, id);
	}
	
	public List<Tarefa> pesquisar(String descricao){
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Tarefa> criteriaQuery = criteriaBuilder.createQuery(Tarefa.class);
		
		Root<Tarefa> root = criteriaQuery.from(Tarefa.class);
		
		criteriaQuery.select(root);				
		criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), descricao + "%"));
		
		TypedQuery<Tarefa> query = manager.createQuery(criteriaQuery);
		
		return query.getResultList();
	}
	
	public List<Tarefa> todas(){
		return manager.createQuery("from Tarefa t", Tarefa.class).getResultList();
	}
	
	
	public Tarefa guardar(Tarefa tarefa) {
		return manager.merge(tarefa);
	}
	
	public void remover(Tarefa tarefa) {
		tarefa = porId(tarefa.getId());
		manager.remove(tarefa);
	}

}
