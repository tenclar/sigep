package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Serie;

public interface SerieBloInterface {
	void salvarSerie(Serie u);
	Serie carregarSerie(long id);
	void atualizarSerie(Serie u);
	void removerSerie(Serie u);
	void removerSerie(long id);
	List<Serie> listarSerie();
	List<Serie> listarSerieNivel(long id);
	List<Serie> listarSerieFiltro(String descricao);
    

    
}