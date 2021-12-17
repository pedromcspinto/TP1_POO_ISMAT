/**
 * @author Pedro Pinto
 * @author Gustavo Paulino
 */
public class Resposta {
	private int numPergunta;
	private String chave;

	Resposta(int numPergunta, String chave) {
		this.numPergunta = numPergunta;
		this.chave = chave;
	}
	/**
	 * Retorna o número da pergunta ao qual esta resposta corresponde
	 * 
	 * @return numero da resposta
	 */
	public int getNumPergunta() {
		return numPergunta;
	}
	/**
	 * Retorna a chave da resposta
	 * 
	 * @return chave da resposta
	 */
	public String getChave() {
		return chave;
	}
}
