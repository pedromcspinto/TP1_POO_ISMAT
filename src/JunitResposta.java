import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitResposta {

	@Test
	void testResposta() {
		Resposta resposta = new Resposta(1, "A");
		assertNotNull(resposta);
		assertEquals(resposta.getNumPergunta(), 1);
		assertEquals(resposta.getChave(), "A");
	}
}
