/**
 * @author Pedro Pinto
 * @author Gustavo Paulino
 */
public class Opcao {
	private String chave;
	private double texto;
	private double cotacao;
	/**
	 * Contrutor da classe Op��o. Inicializa a chave, o texto e a cota��o de cada
	 * op��o de uma pergunta fechada.
	 * 
	 * @param <chave> chave da pergunta
	 * @param <texto> texto da pergunta
	 * @param <cotacao> cota��o da pergunta
	 */
	Opcao(String chave, double texto, double cotacao) {
		this.chave = chave;
		this.texto = texto;
		this.cotacao = cotacao;
	}
	/**
	 * Retorna a chave da op��o
	 * 
	 * @return chave da op��o
	 */
	public String getChave() {
		return chave;
	}
	/**
	 * Retorna a cota��o da op��o
	 * 
	 * @return cota��o da op��o
	 */
	public double getcotacao() {
		return cotacao;
	}
}
