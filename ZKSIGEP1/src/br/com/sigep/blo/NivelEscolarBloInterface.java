package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.NivelEscolar;

public interface NivelEscolarBloInterface {
	void salvarNivelEscolar(NivelEscolar u);
	NivelEscolar carregarNivelEscolar(long id);
	void atualizarNivelEscolar(NivelEscolar u);
	void removerNivelEscolar(NivelEscolar u);
	void removerNivelEscolar(long id);
	List<NivelEscolar> listarNivelEscolar();
	List<NivelEscolar> listarNivelFiltro(String descricao);
	List<NivelEscolar> listarNivelPorAnoLetivo(long idAno);

    
}