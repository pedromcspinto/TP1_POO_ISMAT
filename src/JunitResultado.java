import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class JunitResultado {

	@Test
	void testResultado() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		Aluno a = new Aluno("Pedro");	
		a.setClassificacaoFinal((float) 2.0);
		alunos.add(a);
		Aluno b = new Aluno("Mario");
		b.setClassificacaoFinal((float) 2.0);
		alunos.add(b);
		Aluno c = new Aluno("Filipe");
		c.setClassificacaoFinal((float) 1.0);
		alunos.add(c);
		Aluno d = new Aluno("Rita");	
		d.setClassificacaoFinal((float) 3.0);
		alunos.add(d);
		assertNotNull(alunos);
		assertEquals(alunos.size(), 4);
		assertEquals(alunos.get(0).getNome(), "Pedro");
		assertEquals(alunos.get(1).getNome(), "Mario");
		assertEquals(alunos.get(2).getNome(), "Filipe");
		assertEquals(alunos.get(3).getNome(), "Rita");
		Resultado resultado = new Resultado(alunos);
		assertEquals(resultado.getTurma().get(0).getNome(), "Rita");
		assertEquals(resultado.getTurma().get(1).getNome(), "Mario");
		assertEquals(resultado.getTurma().get(2).getNome(), "Pedro");
		assertEquals(resultado.getTurma().get(3).getNome(), "Filipe");
	}

}
