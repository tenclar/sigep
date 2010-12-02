package teste;

import br.com.sigep.bean.AnoLetivo;

import br.com.sigep.facade.Facade;

public class TesteListarAnosLetivosAluno {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Lista os anos letivos em que o aluno esteve matriculado na instituição
		for(AnoLetivo al : Facade.getInstance().listarAnoLetivoPorMatriculaAluno(242)){
			System.out.println("Ano Letivo >>>>>>>>> " + al.getAno());
		}

	}

}
