package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Resultado;

public interface ResultadoBloInterface {
	void salvarResultado(Resultado u);
	Resultado carregarResultado(long id);
	void atualizarResultado(Resultado u);
	void removerResultado(Resultado u);
	void removerResultado(long id);
	List<Resultado> listarResultado();
	List<Resultado> listarResultadoPorAlunoRegistroDeDisciplinaPeriodoEEtapa(long idAluno, long idRegistro, String periodo, String etapa);
	    
}