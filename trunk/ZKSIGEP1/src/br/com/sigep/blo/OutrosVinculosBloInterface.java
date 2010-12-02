package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.OutrosVinculos;

public interface OutrosVinculosBloInterface {
	void salvarOutrosVinculos(OutrosVinculos u);
	OutrosVinculos carregarOutrosVinculos(long id);
	void atualizarOutrosVinculos(OutrosVinculos u);
	void removerOutrosVinculos(OutrosVinculos u);
	void removerOutrosVinculos(long id);
	List<OutrosVinculos> listarOutrosVinculos();
	List<OutrosVinculos> listarOutrosVinculosFuncionario(long idFuncionario);
    
    

    
}