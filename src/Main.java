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
	 * Método static que lê todo o input. Recebe todo o input necessário, desde as
	 * perguntas a inserir no teste assim como as respetivas classificações, ou no
	 * caso de perguntas fechadas as devidas opções, até aos alunos e cada uma das
	 * suas respostas às questões do teste.
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
	 * Método static que calcula o resultado final Recebe o teste que contém as
	 * perguntas ja inseridad e recebe um ArrayList de alunos já com os alunos e
	 * respetivas respostas inseridas. Para ca aluno no ArrayList calculamos as
	 * classificações finais. No fim esse ArrayList é utilizado para inicializar o
	 * resultado final que irá ordenar os alunos na ordem pretendida através de um
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
	 * Método static lê o resultado final do programa. Recebe um resultado que
	 * ordenou previamente, aquando da sua inicialização, um ArrayList de alunos
	 * ordenados, e para cada aluno existente no mesmo imprime na consola o nome e a
	 * classificação final de cada aluno presente no Arraylist
	 * 
	 * @param <resultado> resultado final do programa
	 */
	private static void lerResultado(Resultado resultado) {
		for (Aluno a : resultado.getTurma())
			System.out.println(a.toString());
	}
}
