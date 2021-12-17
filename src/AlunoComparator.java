import java.util.Comparator;

class AlunosComparator implements Comparator<Aluno> {
	/**
	 * Este comparador compara dois alunos que realizaram o teste.
	 * primeiro compara os alunos por classificação e caso
	 * a classificação seja igual, compara os nomes alfabeticamente.
	 * Irá servir para ordenar os alunos na classe Resultado, para
	 * posterior leitura do mesmo.
	 * 
	 * @param <a1> primeiro aluno a ser comparado
	 * @param <a2> segundo aluno a ser comparado
	 */
	@Override
	public int compare(Aluno a1, Aluno a2) {
		if (Double.compare(a1.getClassificacaoFinal(), a2.getClassificacaoFinal()) > 0)
			return -1;
		else if (Double.compare(a1.getClassificacaoFinal(), a2.getClassificacaoFinal()) < 0)
			return 1;
		else
			return a1.getNome().compareTo(a2.getNome());
	}
}