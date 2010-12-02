package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Bloco;

public interface BlocoBloInterface {
	void salvarBloco(Bloco u);
	Bloco carregarBloco(long id);
	void atualizarBloco(Bloco u);
	void removerBloco(Bloco u);
	void removerBloco(long id);
	List<Bloco> listarBloco();
	List<Bloco> listarBlocoFiltro(String descricao);
    

    
}