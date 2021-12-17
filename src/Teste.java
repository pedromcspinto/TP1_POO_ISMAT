import java.util.*;
/**
 * @author Pedro Pinto
 * @author Gustavo Paulino
 */
public class Teste {
	private int nQuestoes;
	private List<Pergunta> perguntas;
	/**
	 * Contrutor da classe Teste. Recebe e inicializa o número de questões que
	 * irão ser inseridas no teste. Inicializa também o ArrayList de perguntas
	 * 
	 * @param <nQuestoes> numero de questões do teste
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
	 * Retorna o número de questões do teste
	 * 
	 * @return <nQuestoes> O número de questões que estão presentes no teste.
	 */
	public int getNrQuestoes() {
		return nQuestoes;
	}
	/**
	 * Calcula a classificação final de cada aluno que responde ao teste. Começa por
	 * iniciar um ArrayList de cotações, e para cada aluno que respondeu ao teste
	 * será comparado a chave de cada resposta dada, com a chave de cada Pergunta,
	 * ignorando as chaves "-" das respostas a existirem. A cotação de cada uma das
	 * perguntas são adicionadas no ArraylList de cotações, e após o fim da recolha
	 * das mesmas são somadas usando o metodo getClassificacaoFinal
	 * 
	 * @see getClassificacaoFinal(List<Float>cotacoes)
	 * @param <aluno> recebe o aluno ao qual irá ser calculado a classificação
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
	 * Soma todas as cotações das respostas de um aluno.
	 * 
	 * @param <cotacoes> lista de todas as cotações de um aluno.
	 * @return <classificacaoFinal> classificação final de casa aluno.
	 */
	public double getClassificacaoFinal(List<Double> cotacoes) {
		double classificacaoFinal = 0;
		for (double c : cotacoes) classificacaoFinal += c;	
		return classificacaoFinal;
	}
}
