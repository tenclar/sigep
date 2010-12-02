package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Permissao;

public interface PermissaoBloInterface {
	void salvarPermissao(Permissao u);
	Permissao carregarPermissao(long id);
	void atualizarPermissao(Permissao u);
	void removerPermissao(Permissao u);
	void removerPermissao(long id);
	List<Permissao> listarPermissao();
	List<Permissao> listarPermissaoFiltro(int descricao);
    
    

    
}