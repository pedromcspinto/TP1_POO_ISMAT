/**
 * @author Pedro Pinto
 * @author Gustavo Paulino
 */
public class PerguntaAberta implements Pergunta {
	private int numPergunta;
	private String texto;
	private double classificacao;
	/**
	 * Contrutor da classe Pergunta Aberta
	 * 
	 * @param texto texto da pergunta
	 * @param classificacao cotação da pergunta
	 */
	PerguntaAberta(int numPergunta, String texto, double classificacao) {
		this.numPergunta = numPergunta;
		this.texto = texto;
		this.classificacao = classificacao;
	}
}
