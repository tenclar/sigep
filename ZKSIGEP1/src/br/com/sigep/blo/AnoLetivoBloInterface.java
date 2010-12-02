package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.AnoLetivo;

public interface AnoLetivoBloInterface {
	void salvarAnoLetivo(AnoLetivo u);
	AnoLetivo carregarAnoLetivo(long id);
	void atualizarAnoLetivo(AnoLetivo u);
	void removerAnoLetivo(AnoLetivo u);
	void removerAnoLetivo(long id);
	List<AnoLetivo> listarAnoLetivo();
	List<AnoLetivo> listarAnoLetivoFiltro(int descricao);
	List<AnoLetivo> listarAnoLetivoPorMatriculaAluno(long idAluno);
	List<AnoLetivo> listarAnoLetivoNosQuaisOAlunoNaoFoiMatriculado(long idAluno);
	List<AnoLetivo> listarAnoLetivoNosQuaisOAlunoFoiMatriculado(long idAluno);

    
}