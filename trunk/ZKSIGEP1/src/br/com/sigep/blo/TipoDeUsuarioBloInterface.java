package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.TipoDeUsuario;

public interface TipoDeUsuarioBloInterface {
	void salvarTipoDeUsuario(TipoDeUsuario u);
	TipoDeUsuario carregarTipoDeUsuario(long id);
	void atualizarTipoDeUsuario(TipoDeUsuario u);
	void removerTipoDeUsuario(TipoDeUsuario u);
	void removerTipoDeUsuario(long id);
	List<TipoDeUsuario> listarTipoDeUsuario();
	List<TipoDeUsuario> listarTipoDeUsuarioFiltro(String descricao);
    
    

    
}