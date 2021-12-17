/**
 * @author Pedro Pinto
 * @author Gustavo Paulino
 */
public class Opcao {
	private String chave;
	private double texto;
	private double cotacao;
	/**
	 * Contrutor da classe Opção. Inicializa a chave, o texto e a cotação de cada
	 * opção de uma pergunta fechada.
	 * 
	 * @param <chave> chave da pergunta
	 * @param <texto> texto da pergunta
	 * @param <cotacao> cotação da pergunta
	 */
	Opcao(String chave, double texto, double cotacao) {
		this.chave = chave;
		this.texto = texto;
		this.cotacao = cotacao;
	}
	/**
	 * Retorna a chave da opção
	 * 
	 * @return chave da opção
	 */
	public String getChave() {
		return chave;
	}
	/**
	 * Retorna a cotação da opção
	 * 
	 * @return cotação da opção
	 */
	public double getcotacao() {
		return cotacao;
	}
}
