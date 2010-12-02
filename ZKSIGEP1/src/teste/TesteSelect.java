package teste;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.sigep.facade.Facade;

public class TesteSelect {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		float notasemestre1Portugues = 0;
		float notasemestre2Portugues = 0;
		float notafinalPortugues = 0;
		
		Connection conexao = Facade.getInstance().getConnection();
		
		
		String select = ("SELECT rf.notasemestre1, rf.notasemestre2, rf.notafinal FROM  disciplina d, aluno a, pessoa p, resultadofinal rf, registrodedisciplina rdd, turma t, serie s, nivelescolar ne, anoletivo al, matricula m WHERE rf.aluno = a.pessoa_id and p.id = a.pessoa_id and rdd.id = rf.registrodedisciplina and rdd.disciplina = d.id and rdd.turma = t.id and t.serie = s.id and s.nivelescolar = ne.id and t.anoletivo = al.id and m.turma = t.id and rf.aluno = 242 and s.nivelescolar = 66 and al.id = 16 and s.descricao = '1º Ano' and d.nome ='Português' GROUP BY rf.notasemestre1, rf.notasemestre2, rf.notafinal");
		String selectFinal = select;
		
		Statement stmt = conexao.createStatement();
		ResultSet rs = stmt.executeQuery(selectFinal);
		while(rs.next()){
			notasemestre1Portugues = rs.getFloat("notasemestre1");
			notasemestre2Portugues = rs.getFloat("notasemestre2");
			notafinalPortugues = rs.getFloat("notafinal");
		}
		//stmt.close();
		
		
		System.out.println(notasemestre1Portugues + " <-> " + notasemestre2Portugues + " <-> " + notafinalPortugues);
		//////////////////////////////

	}

}
