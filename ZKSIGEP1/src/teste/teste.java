package teste;


import br.com.sigep.bean.Aluno;
import br.com.sigep.bean.Funcionario;
import br.com.sigep.bean.ResultadoFinal;
import br.com.sigep.bean.TipoDeUsuario;
import br.com.sigep.facade.Facade;

public class teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (ResultadoFinal rf: Facade.getInstance().listarNotasPorPeriodo
				(221, 174)){
			
			System.out.println("NOTAAAAAAAAAAAAAAAAAAAAAAAAA   " + rf.getNotasFinais().get("1º Período:1ª Etapa"));
			
			//System.out.println("RESULTADO FINALLLL   " + rf.getNotasFinais().toString());
			//System.out.println("MATERIA   " + rf.getRegistroDeDisciplina().getDisciplina().getNome());
			
		}
	
		TipoDeUsuario tp = new TipoDeUsuario();
		tp.setDescricao("ROLE_ADMINISTRADOR");
		Facade.getInstance().salvarTipoDeUsuario(tp);
		
		Funcionario f = new Funcionario();
		f.getUsuario().setUsuario("Admin");
		f.getUsuario().setSenha("Admin");
		f.getUsuario().setTipoDeUsuario(tp);
		f.setNome("Administrador");
		
		Facade.getInstance().salvarFuncionario(f);
		
		
		
	}
	
	

}
