import java.util.*;
/**
 * @author Pedro Pinto
 * @author Gustavo Paulino
 */
public class Teste {
	private int nQuestoes;
	private List<Pergunta> perguntas;
	/**
	 * Contrutor da classe Teste. Recebe e inicializa o n�mero de quest�es que
	 * ir�o ser inseridas no teste. Inicializa tamb�m o ArrayList de perguntas
	 * 
	 * @param <nQuestoes> numero de quest�es do teste
	 */
	Teste(int nQuestoes) {
		this.nQuestoes = nQuestoes;
		this.perguntas = new ArrayList<Pergunta>();
	}
	/**
	 * Insere um objeto do tipo pergunta dentro do ArrayList de Perguntas.
	 * 
	 * @param <pergunta> Uma pergunta do tipo Pergunta
	 */
	public void inserePergunta(Pergunta pergunta) {
		perguntas.add(pergunta);
	}
	/**
	 * Retorna o n�mero de quest�es do teste
	 * 
	 * @return <nQuestoes> O n�mero de quest�es que est�o presentes no teste.
	 */
	public int getNrQuestoes() {
		return nQuestoes;
	}
	/**
	 * Calcula a classifica��o final de cada aluno que responde ao teste. Come�a por
	 * iniciar um ArrayList de cota��es, e para cada aluno que respondeu ao teste
	 * ser� comparado a chave de cada resposta dada, com a chave de cada Pergunta,
	 * ignorando as chaves "-" das respostas a existirem. A cota��o de cada uma das
	 * perguntas s�o adicionadas no ArraylList de cota��es, e ap�s o fim da recolha
	 * das mesmas s�o somadas usando o metodo getClassificacaoFinal
	 * 
	 * @see getClassificacaoFinal(List<Float>cotacoes)
	 * @param <aluno> recebe o aluno ao qual ir� ser calculado a classifica��o
	 *        final.
	 */
	public void getResultadoFinal(Aluno aluno) {
		List<Double> cotacoes = new ArrayList<Double>();
		for (int i = 0; i < aluno.getRespostasSize(); i++) {
			if (perguntas.get(i) instanceof PerguntaAberta && !aluno.getChaveDaResposta(i).equals("-"))
				cotacoes.add(Double.parseDouble(aluno.getChaveDaResposta(i)));
			if (perguntas.get(i) instanceof PerguntaFechada && !aluno.getChaveDaResposta(i).equals("-"))
				cotacoes.add(((PerguntaFechada) perguntas.get(i)).getCotacaoDaOpcao(aluno.getChaveDaResposta(i)));
		}
		aluno.setClassificacaoFinal(getClassificacaoFinal(cotacoes));
	}
	/**
	 * Soma todas as cota��es das respostas de um aluno.
	 * 
	 * @param <cotacoes> lista de todas as cota��es de um aluno.
	 * @return <classificacaoFinal> classifica��o final de casa aluno.
	 */
	public double getClassificacaoFinal(List<Double> cotacoes) {
		double classificacaoFinal = 0;
		for (double c : cotacoes) classificacaoFinal += c;	
		return classificacaoFinal;
	}
}
