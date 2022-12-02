package ArvoreBinaria;

public class AlgoritmoVetor {
	public static void algVetor(int vetor[], int menor, int maior) {
		if(menor < maior) {
			int meio = (menor + maior) / 2;
			int valor = vetor[meio];
			MainAula11.arvoreBalanceada.inserir(valor);
			algVetor(vetor, menor, meio);
			algVetor(vetor, meio + 1, maior);
		}
	}
}
