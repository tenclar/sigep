package teste;


import br.com.sigep.facade.Facade;

public class TesteValidandoCPF {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean x =	Facade.getInstance().validacaoCPF("64734407800");
		System.out.println(">>>>>>))))))))))))))))(((((((((((" + x);
		
		/*
		// a senha que vc quer testar  
		String teste1 = "030.99";   
		// "compila"a express�o que ser� usada  
		Pattern p = Pattern.compile(".[0-9]+");   
		// "pega" informa��es da strring que vc quer testar  
		Matcher m = p.matcher(teste1);  
		  
		// confere para ver se a senha passada bate exatamente com o  
		// padr�o  
		if ( m.matches() ) {  
		    System.out.println("Senha ok" + m.matches());  
		} else {  
		    System.out.println("Senha n�o est� ok" + m.matches());  
		}  
		  
		String teste2 = "22222";  
		m = p.matcher(teste2);  
		  
		if ( m.matches() ) {  
		    System.out.println("Senha ok");  
		} else {  
		    System.out.println("Senha n�o est� ok");  
		} */
		
		if(Facade.getInstance().verificarSeENumero("033333666663") == false){
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>  N�o � N�mero Doido!!!!");
		}else{
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>  � N�mero Doido!!!!");
		}
		

		

	}

}
