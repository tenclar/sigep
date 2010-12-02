package teste;

import br.com.sigep.bean.NivelEscolar;
import br.com.sigep.bean.Sala;
import br.com.sigep.bean.Turma;
import br.com.sigep.facade.Facade;

public class TesteListarNivelPorAnoLetivo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	for(NivelEscolar n : Facade.getInstance().listarNivelPorAnoLetivo(16)){
	//		System.out.println("Nivel:" + n.getNivel());
	//	}
		

		long idSala = 0;
		for (Sala s : Facade.getInstance().listarSala()){
			for(Turma t : Facade.getInstance().listarTurma()){
				if(s.getId() == t.getSala().getId() && t.getTurno().equalsIgnoreCase("Matutino") && t.getAnoLetivo().getId() == 16 && idSala != s.getId()){
					 System.out.println("SALA >>>>>" + s.getDescricao());
				}
				idSala = s.getId();
			}
			
		}
		

	}

}
