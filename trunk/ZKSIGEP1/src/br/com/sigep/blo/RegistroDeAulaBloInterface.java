package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.RegistroDeAula;

public interface RegistroDeAulaBloInterface {
	void salvarRegistroDeAula(RegistroDeAula u);
	RegistroDeAula carregarRegistroDeAula(long id);
	void atualizarRegistroDeAula(RegistroDeAula u);
	void removerRegistroDeAula(RegistroDeAula u);
	void removerRegistroDeAula(long id);
	List<RegistroDeAula> listarRegistroDeAula();
	List<RegistroDeAula> listarRegistroDeAulaFiltro(String assunto);
    
    

    
}