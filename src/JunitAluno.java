import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitAluno {
	@Test
	void testName() {
		Aluno a = new Aluno("Pedro");
		assertNotNull(a.getNome());
		assertSame(a.getNome(), "Pedro");
	}
	@Test
	void testSetClassificacao() {
		Aluno a = new Aluno("Pedro");
		a.setClassificacaoFinal(3);
		assertNotNull(a.getClassificacaoFinal());
		assertEquals(a.getClassificacaoFinal(), 3.0);
	}	
	@Test
	void testGetRespostasSize() {
		Aluno a = new Aluno("Pedro");
		a.insereResposta(new Resposta(1, "A"));
		a.insereResposta(new Resposta(2, "B"));	
		assertEquals(a.getRespostasSize(), 2);
		
	}	
	@Test
	void testToString() {
		Aluno a = new Aluno("Pedro");
		a.setClassificacaoFinal(2.5);
		assertEquals(a.toString(), "Pedro 2.5");
	}
}
