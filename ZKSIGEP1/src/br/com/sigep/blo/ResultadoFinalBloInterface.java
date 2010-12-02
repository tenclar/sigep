package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.ResultadoFinal;
import br.com.sigep.dao.DaoException;

public interface ResultadoFinalBloInterface {
	void salvarResultadoFinal(ResultadoFinal u);
	ResultadoFinal carregarResultadoFinal(long id);
	void atualizarResultadoFinal(ResultadoFinal u);
	void removerResultadoFinal(ResultadoFinal u);
	void removerResultadoFinal(long id);
	List<ResultadoFinal> listarResultadoFinal();
	List<ResultadoFinal> listarNotasPorPeriodo(long idAluno, long idTurma);
    
    

    
}