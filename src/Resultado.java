import java.util.*;

/**
 * @author Pedro Pinto
 * @author Gustavo Paulino
 */
public class Resultado {
	private List<Aluno> alunos;
	/**
	 * Construtor da classe Resultado Recebe e inicializa um Arraylist de alunos e
	 * ainda ordena o mesmo comparando alunos, primeiro pela classificação final e
	 * depois pelo nome usando o comparador
	 * 
	 * @see AlunosComparator()
	 * @param <alunos> ArrayList de alunos
	 */
	Resultado(List<Aluno> alunos) {
		this.alunos = alunos;
		Collections.sort(this.alunos, new AlunosComparator());
	}
	/**
	 * Retorn o ArrayList de alunos já ordenado usando o comparador
	 * 
	 * @return ArrayList de alunos
	 */
	public List<Aluno> getTurma() {
		return alunos;
	}
}
