package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Registro;

public interface RegistroBloInterface {
	void salvarRegistro(Registro u);
	Registro carregarRegistro(long id);
	void atualizarRegistro(Registro u);
	void removerRegistro(Registro u);
	void removerRegistro(long id);
	List<Registro> listarRegistro();
    
    

    
}