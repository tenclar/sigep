package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Ocorrencia;

public interface OcorrenciaBloInterface {
	void salvarOcorrencia(Ocorrencia u);
	Ocorrencia carregarOcorrencia(long id);
	void atualizarOcorrencia(Ocorrencia u);
	void removerOcorrencia(Ocorrencia u);
	void removerOcorrencia(long id);
	List<Ocorrencia> listarOcorrencia();
	List<Ocorrencia> listarOcorrenciaFiltro(String descricao);
	
    

    
}