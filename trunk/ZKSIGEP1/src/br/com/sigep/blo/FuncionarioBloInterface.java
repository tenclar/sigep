package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Funcionario;

public interface FuncionarioBloInterface {
	void salvarFuncionario(Funcionario u);
	Funcionario carregarFuncionario(long id);
	void atualizarFuncionario(Funcionario u);
	void removerFuncionario(Funcionario u);
	void removerFuncionario(long id);
	List<Funcionario> listarFuncionario();
	List<Funcionario> listarFuncionarioFiltro(String nome);
	Funcionario procurarFuncionarioPorCPF(String cpf);
	Funcionario procurarFuncionarioPorRg(String rg);
    

    
}