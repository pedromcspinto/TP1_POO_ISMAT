import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitOpcao {

	@Test
	void testOpcao() {
		Opcao opcao = new Opcao("A", (float)-2.5, (float) 3.0);
		assertEquals(opcao.getChave(), "A");
		assertEquals(opcao.getcotacao(), 3.0);
	}

}
