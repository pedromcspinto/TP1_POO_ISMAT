import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class JunitTeste {

	@Test  
	public void testInserirPerguntas() {
		Teste t = new Teste(3);
		assertNotNull(t.getNrQuestoes());
		assertEquals(t.getNrQuestoes(), 3);
	}
	@Test 
	public void testCalculoNota() {
		Teste t = new Teste(2);	
		Pergunta p1 = new PerguntaFechada(1, "Ola");
		Pergunta p2 = new PerguntaFechada(2, "Ola");
		((PerguntaFechada) p1).inserirOpcao(new Opcao("A", 1, 2));
		((PerguntaFechada) p1).inserirOpcao(new Opcao("B", 2, 1));
		((PerguntaFechada) p1).inserirOpcao(new Opcao("C", 3, 0));
		((PerguntaFechada) p1).inserirOpcao(new Opcao("D", 4, -1));
		((PerguntaFechada) p2).inserirOpcao(new Opcao("A", 1, 2));
		((PerguntaFechada) p2).inserirOpcao(new Opcao("B", 2, 1));
		((PerguntaFechada) p2).inserirOpcao(new Opcao("C", 3, 0));
		((PerguntaFechada) p2).inserirOpcao(new Opcao("D", 4, -1));
		t.inserePergunta(p1);
		t.inserePergunta(p2);
		Aluno a = new Aluno("Pedro");
		a.insereResposta(new Resposta(1, "A"));
		a.insereResposta(new Resposta(2, "A"));	
		t.getResultadoFinal(a);
		assertEquals(a.getClassificacaoFinal(), 4.0);	
		Aluno b = new Aluno("Mario");
		b.insereResposta(new Resposta(1, "B"));
		b.insereResposta(new Resposta(2, "D"));
		assertEquals(b.getClassificacaoFinal(), 0.0);
		Aluno c = new Aluno("Filipe");
		c.insereResposta(new Resposta(1, "C"));
		c.insereResposta(new Resposta(2, "C"));
		assertEquals(c.getClassificacaoFinal(), 0.0);
	}
	@Test  
	public void calculaCotacoes() {
		Teste t = new Teste(2);
		List<Double> cotacoes = new ArrayList<Double>();
		cotacoes.add(1.0);
		cotacoes.add(2.0);
		cotacoes.add(3.0);
		assertNotNull(cotacoes);
		assertEquals(cotacoes.size(), 3);
		assertEquals(t.getClassificacaoFinal(cotacoes), 6.0);
	}
}
