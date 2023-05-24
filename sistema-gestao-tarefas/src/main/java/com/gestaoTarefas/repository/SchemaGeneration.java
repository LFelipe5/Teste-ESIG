package com.gestaoTarefas.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gestaoTarefas.model.Tarefa;

public class SchemaGeneration {
	

	
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TarefaGestao");
		
		EntityManager em = emf.createEntityManager();
		
		List<Tarefa> lista = em.createQuery("from Tarefa t", Tarefa.class)
				.getResultList();
		
		System.out.println(lista);
		
		em.close();
		emf.close();
	}

}