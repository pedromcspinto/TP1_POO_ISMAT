import java.io.*;
import java.util.*;
/**
 * @author Pedro Pinto
 * @author Gustavo Paulino
 */
public class Main {
	/**
	 * Main Inicializa o Scanner, o ArrayList de alunos e um resultado
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		try {
		System.setIn(new FileInputStream("Input.txt"));
		}catch(FileNotFoundException e) {
			System.out.println(e.toString());
		}
		Scanner in = new Scanner(System.in);
		List<Aluno> alunos = new ArrayList<Aluno>();
		Resultado resultado;
		Teste teste = new Teste(Integer.parseInt(in.nextLine()));
		getInput(in, teste, alunos);
		resultado = calculaResultados(teste, alunos);
		lerResultado(resultado);
		in.close();
	}
	/**
	 * M�todo static que l� todo o input. Recebe todo o input necess�rio, desde as
	 * perguntas a inserir no teste assim como as respetivas classifica��es, ou no
	 * caso de perguntas fechadas as devidas op��es, at� aos alunos e cada uma das
	 * suas respostas �s quest�es do teste.
	 * 
	 * @param <in> Scanner
	 * @param <teste> teste modelo
	 * @param <alunos> ArrayList de alunos
	 */
	public static void getInput(Scanner in, Teste teste, List<Aluno> alunos) {
		for (int i = 0; i < teste.getNrQuestoes(); i++) {
			String pergunta = in.nextLine();
			String[] split = pergunta.trim().split(" ");
			if (split[1].toUpperCase().equals("A")) {
				teste.inserePergunta(new PerguntaAberta(Integer.parseInt(split[0]), pergunta.substring(4),
						Double.parseDouble(in.nextLine())));
			}
			if (split[1].toUpperCase().equals("F")) {
				Pergunta p = new PerguntaFechada(Integer.parseInt(split[0]), pergunta.substring(4));
				for (int j = 0; j < 4; j++) {
					String[] opcao = in.nextLine().trim().split(" ");
					((PerguntaFechada) p).inserirOpcao(
							new Opcao(opcao[0], Double.parseDouble(opcao[1]), Double.parseDouble(opcao[2])));
				}
				teste.inserePergunta(p);
			}
		}
		int numAlunos = in.nextInt(); in.nextLine();
		for (int i = 0; i < numAlunos; i++) {
			alunos.add(new Aluno(in.nextLine()));
			for (int j = 0; j < teste.getNrQuestoes(); j++) {
				String[] respostaSplit = in.nextLine().trim().split(" ");
				alunos.get(i).insereResposta(new Resposta(Integer.parseInt(respostaSplit[0]), respostaSplit[1]));
			}
		}
	}
	/**
	 * M�todo static que calcula o resultado final Recebe o teste que cont�m as
	 * perguntas ja inseridad e recebe um ArrayList de alunos j� com os alunos e
	 * respetivas respostas inseridas. Para ca aluno no ArrayList calculamos as
	 * classifica��es finais. No fim esse ArrayList � utilizado para inicializar o
	 * resultado final que ir� ordenar os alunos na ordem pretendida atrav�s de um
	 * comparador.
	 * 
	 * @param <teste> teste modelo
	 * @param <alunos> ArrayList de alunos
	 * @return <resultado> um objeto resultado que recebe a lista de alunos e a
	 *         ordena.
	 */
	public static Resultado calculaResultados(Teste teste, List<Aluno> alunos) {
		for (Aluno a : alunos)
			teste.getResultadoFinal(a);
		Resultado resultado = new Resultado(alunos);
		return resultado;
	}
	/**
	 * M�todo static l� o resultado final do programa. Recebe um resultado que
	 * ordenou previamente, aquando da sua inicializa��o, um ArrayList de alunos
	 * ordenados, e para cada aluno existente no mesmo imprime na consola o nome e a
	 * classifica��o final de cada aluno presente no Arraylist
	 * 
	 * @param <resultado> resultado final do programa
	 */
	private static void lerResultado(Resultado resultado) {
		for (Aluno a : resultado.getTurma())
			System.out.println(a.toString());
	}
}
