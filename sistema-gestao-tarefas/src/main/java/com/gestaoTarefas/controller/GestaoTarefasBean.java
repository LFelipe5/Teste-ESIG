package com.gestaoTarefas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gestaoTarefas.model.Tarefa;
import com.gestaoTarefas.repository.Tarefas;
import com.gestaoTarefas.service.CadastroTarefaService;

@Named
@ViewScoped
public class GestaoTarefasBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Tarefa tarefa = new Tarefa();
	@Inject
	private Tarefas tarefas;
	@Inject
	private CadastroTarefaService cadastroTarefaService;
	
	private List<Tarefa> listaDeTarefas;
	
	
	
	
	public String listar() {
		return "listaTarefas?faces-redirect=true";
	}
	public void novaTarefa() {
		tarefa = new Tarefa();
	}
	
	public void salvar() {
		cadastroTarefaService.salvar(tarefa);
	}
	
	public void buscar_tarefas() {
		
	}
	
	public List<Tarefa> getListaTarefas() {
	        return listaDeTarefas;
	}
	
	public void TodasTarefas() {
		listaDeTarefas = tarefas.todas();
	}
	
	public Tarefa getTarefa() {
		return tarefa;
	}
}
