package teste;

import br.com.sigep.bean.Matricula;
import br.com.sigep.facade.Facade;

public class TesteProcurarUltimaMatriculaDoAluno {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(Matricula m: Facade.getInstance().listarMatriculaAlunoRG("010101")){
			System.out.println("********************" +m.getNumero() + " - " + m.getId());
		}
	

		
	}

}
