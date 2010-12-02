package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Usuario;

public interface UsuarioBloInterface {
	void salvarUsuario(Usuario u);
	Usuario carregarUsuario(long id);
	void atualizarUsuario(Usuario u);
	void removerUsuario(Usuario u);
	void removerUsuario(long id);
	List<Usuario> listarUsuario();
    
    

    
}