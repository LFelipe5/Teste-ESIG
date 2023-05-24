package com.gestaoTarefas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.gestaoTarefas.model.Tarefa;
import com.gestaoTarefas.repository.Tarefas;
import com.gestaoTarefas.util.Transacional;

public class CadastroTarefaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Tarefas empresas;
	
	@Transacional
	public void salvar(Tarefa tarefa) {
		empresas.guardar(tarefa);
	}
	
	@Transacional
	public void excluir(Tarefa tarefa) {
		empresas.remover(tarefa);
	}

}