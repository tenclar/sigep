package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.RecomendacoesMedicas;

public interface RecomendacoesMedicasBloInterface {
	void salvarRecomendacoesMedicas(RecomendacoesMedicas u);
	RecomendacoesMedicas carregarRecomendacoesMedicas(long id);
	void atualizarRecomendacoesMedicas(RecomendacoesMedicas u);
	void removerRecomendacoesMedicas(RecomendacoesMedicas u);
	void removerRecomendacoesMedicas(long id);
	List<RecomendacoesMedicas> listarRecomendacoesMedicas();
    
    

    
}