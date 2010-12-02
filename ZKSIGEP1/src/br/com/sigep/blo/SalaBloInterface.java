package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Sala;

public interface SalaBloInterface {
	void salvarSala(Sala u);
	Sala carregarSala(long id);
	void atualizarSala(Sala u);
	void removerSala(Sala u);
	void removerSala(long id);
	List<Sala> listarSala();
	List<Sala> listarSalaFiltro(String descricao);
    

    
}