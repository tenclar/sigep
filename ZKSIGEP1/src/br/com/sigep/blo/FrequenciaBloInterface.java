package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Frequencia;

public interface FrequenciaBloInterface {
	void salvarFrequencia(Frequencia u);
	Frequencia carregarFrequencia(long id);
	void atualizarFrequencia(Frequencia u);
	void removerFrequencia(Frequencia u);
	void removerFrequencia(long id);
	List<Frequencia> listarFrequencia();
    
    

    
}