package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Afastamento;

public interface AfastamentoBloInterface {
	void salvarAfastamento(Afastamento u);
	Afastamento carregarAfastamento(long id);
	void atualizarAfastamento(Afastamento u);
	void removerAfastamento(Afastamento u);
	void removerAfastamento(long id);
	List<Afastamento> listarAfastamento();
	List<Afastamento> listarAfastamentoFiltro(String descricao);    

    
}