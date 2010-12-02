package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.DadosBancarios;

public interface DadosBancariosBloInterface {
	void salvarDadosBancarios(DadosBancarios u);
	DadosBancarios carregarDadosBancarios(long id);
	void atualizarDadosBancarios(DadosBancarios u);
	void removerDadosBancarios(DadosBancarios u);
	void removerDadosBancarios(long id);
	List<DadosBancarios> listarDadosBancarios();
    
    

    
}