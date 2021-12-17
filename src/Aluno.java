import java.util.*;
/**
 * @author Pedro Pinto
 * @author Gustavo Paulino
 */
public class Aluno {
	private static final String SPACE = " ";
	private String nome;
	private List<Resposta> respostas;
	private double classificacaoFinal;
	/**
	 * Contrutor da classe Aluno. Recebe uma String nome, que ir� ser o nome
	 * associado ao aluno. inicializa o nome, o ArrayList de respostas e a
	 * classifica��o final do aluno.
	 * 
	 * @param <nome> nome do aluno
	 */
	Aluno(String nome) {
		this.nome = nome;
		this.respostas = new ArrayList<Resposta>();
		this.classificacaoFinal = 0;
	}
	/**
	 * Retorna o nome do aluno
	 * 
	 * @return <nome> nome do aluno
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Insere no ArrayList de respostas, a resposta dada pelo aluno a uma quest�o do
	 * teste.
	 * 
	 * @param <resposta> Resposta dada pelo aluno a uma quest�o do teste
	 */
	public void insereResposta(Resposta resposta) {
		respostas.add(resposta);
	}
	/**
	 * Altera a classifica��o final do aluno
	 * 
	 * @param <classificacaoFinal> a classifica��o final calculada
	 */
	public void setClassificacaoFinal(double classificacaoFinal) {
		this.classificacaoFinal = classificacaoFinal;
	}
	/**
	 * Retorna a classifica��o do aluno.
	 * 
	 * @return <classificacaoFinal> classifica��o final do aluno.
	 */
	public double getClassificacaoFinal() {
		return classificacaoFinal;
	}
	/**
	 * retorna o ArrayList de respostas do aluno
	 * 
	 * @return <respostas> o ArrayList de respostas do aluno.
	 */
	public int getRespostasSize() {
		return respostas.size();
	}
	/**
	 * Retorn a chave da resposta com �ndice i
	 * 
	 * @param <i> �ndice da resposta
	 * @return chave da resposta com indice i
	 */
	public String getChaveDaResposta(int i) {
		return respostas.get(i).getChave();
	}
	/**
	 * M�todo toString para imprimir o Objeto aluno no formato desejado
	 */
	public String toString() {
		return this.nome + SPACE + this.classificacaoFinal;
	}
}
