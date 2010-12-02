package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.DadosFuncionais;

public interface DadosFuncionaisBloInterface {
	void salvarDadosFuncionais(DadosFuncionais u);
	DadosFuncionais carregarDadosFuncionais(long id);
	void atualizarDadosFuncionais(DadosFuncionais u);
	void removerDadosFuncionais(DadosFuncionais u);
	void removerDadosFuncionais(long id);
	List<DadosFuncionais> listarDadosFuncionais();
    
    

    
}