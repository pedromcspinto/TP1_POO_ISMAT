import java.util.*;
/**
 * @author Pedro Pinto
 * @author Gustavo Paulino
 */
public class PerguntaFechada implements Pergunta {
	private int numPergunta;
	private String texto;
	private List<Opcao> opcoes;
	private double cotacao;
	
	PerguntaFechada(int numPergunta, String texto) {
		this.numPergunta = numPergunta;
		this.texto = texto;
		this.opcoes = new ArrayList<Opcao>();
		this.cotacao = 0;
	}
	/**
	 * Insere na pergunta as suas op�oes
	 * 
	 * @param <opcao> op��o a ser inserida
	 */
	public void inserirOpcao(Opcao opcao) {
		opcoes.add(opcao);
	}
	/**
	 * Retorna a cota��o da pergunta ao qual foi comparada a chave recebida com
	 * sucesso.
	 * 
	 * @param <chave> chave da resposta de cada aluno
	 * @return cota��o da opc�o
	 */
	public double getCotacaoDaOpcao(String chave) {
		for (Opcao opcao : opcoes)
			if (opcao.getChave().equals(chave)) 
				cotacao = opcao.getcotacao();
		return cotacao;
	}
}
