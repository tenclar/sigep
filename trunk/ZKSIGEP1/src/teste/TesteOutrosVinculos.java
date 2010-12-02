package teste;

import br.com.sigep.bean.Funcionario;
import br.com.sigep.bean.OutrosVinculos;
import br.com.sigep.facade.Facade;

public class TesteOutrosVinculos {
	public static void main(String[] args) {
		
	Funcionario fn = new Funcionario();
	OutrosVinculos o1 = new OutrosVinculos();
	//o1.setId(1);
	o1.setCargo("Professor");
	o1.setCargaHoraria(20);
	o1.setOrgao("UNEB");
	o1.setStatus(true);
	
	OutrosVinculos o2 = new OutrosVinculos();
	//o2.setId(2);
	o2.setCargo("Estagiário");
	o2.setCargaHoraria(20);
	o2.setOrgao("FASETE");
	o2.setStatus(true);
	
	OutrosVinculos o3 = new OutrosVinculos();
	//o3.setId(3);
	o3.setCargo("Tecnico");
	o3.setCargaHoraria(20);
	o3.setOrgao("PMPA");
	o3.setStatus(true);
	
	fn.getOutrosVinculos().add(o1);
	fn.getOutrosVinculos().add(o2);
	fn.getOutrosVinculos().add(o3);
	
	Facade.getInstance().salvarFuncionario(fn);
	
		
	}
}
