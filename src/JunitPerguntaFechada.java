import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitPerguntaFechada {

	@Test
	void testInsereOpcao() {
		Pergunta p = new PerguntaFechada(1 ,"String");
		assertTrue(p instanceof Pergunta);
		assertTrue(p instanceof PerguntaFechada);
		assertNotNull(p);
		((PerguntaFechada)p).inserirOpcao(new Opcao("A", (float)-2.5, (float) 3.0));
		((PerguntaFechada)p).inserirOpcao(new Opcao("B", (float)-2.5, (float) -3.0));
		assertEquals(((PerguntaFechada)p).getCotacaoDaOpcao("A"), 3.0);
		assertEquals(((PerguntaFechada)p).getCotacaoDaOpcao("B"), -3.0);
	}

}
