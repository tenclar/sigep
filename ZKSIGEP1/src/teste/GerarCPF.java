package teste;

import java.util.Random;

public class GerarCPF {
	
	   public static void main(String args [])  
	   {  
	      int[] vet = new int[11];  
	      int[] vet2 = new int[11];  
	      int multPrimeiroDV = 10,multSegundoDv = 11,soma=0, soma2 =0;;  
	  
	      Random aleatorio = new Random();  
	      for(int i = 0;i <9; i++)  
	       vet[i] = aleatorio.nextInt(9);  
	  
	      //Para calcular o primeiro digito verificador  
	      for(int i =0; i<9;i++)  
	      {  
	         vet2[i]= vet[i]* multPrimeiroDV;  
	         multPrimeiroDV--;  
	      }  
	  
	      for(int i =0; i<9;i++)  
	      {  
	         soma += vet2[i];  
	      }  
	      int resto = soma % 11;  
	  
	      if(resto < 2)  
	         vet[9] = 0;  
	      else  
	         vet[9] = 11 - resto;  
	  
	  
	      //para calcular o segundo digito verificador  
	      for(int i =0; i<10;i++)  
	      {  
	         vet2[i]= vet[i]* multSegundoDv;  
	         multSegundoDv--;  
	      }  
	  
	      for(int i =0; i<10;i++)  
	      {  
	         soma2 += vet2[i];  
	      }  
	  
	      int resto2 = soma2 % 11;  
	  
	      if(resto < 2)  
	         vet[10] = 0;  
	      else  
	         vet[10] = 11 - resto2;  
	  
	  
	      System.out.print("CPF VÁLIDO: ");  
	      for(int i = 0;i <vet.length; i++)  
	          System.out.print(vet[i]);  
	        
	   }  
	  
 

}
