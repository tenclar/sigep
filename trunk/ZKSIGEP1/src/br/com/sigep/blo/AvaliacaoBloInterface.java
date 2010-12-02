package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Avaliacao;

public interface AvaliacaoBloInterface {
	void salvarAvaliacao(Avaliacao u);
	Avaliacao carregarAvaliacao(long id);
	void atualizarAvaliacao(Avaliacao u);
	void removerAvaliacao(Avaliacao u);
	void removerAvaliacao(long id);
	List<Avaliacao> listarAvaliacao();
	List<Avaliacao> listarAvaliacaoFiltro(String descricao);
    
    

    
}