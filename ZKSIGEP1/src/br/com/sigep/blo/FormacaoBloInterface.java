package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Formacao;

public interface FormacaoBloInterface {
	void salvarFormacao(Formacao u);
	Formacao carregarFormacao(long id);
	void atualizarFormacao(Formacao u);
	void removerFormacao(Formacao u);
	void removerFormacao(long id);
	List<Formacao> listarFormacao();
	List<Formacao> listarFormacaoFuncionario(long idFuncionario);
    
    

    
}