package SortingClasses;

public class MergeSort {
	long nMovimentos = 0;
	long nComparacao = 0;

	public void mergeSort(int[] vetor, int[] vetorAux, int menor, int maior) {
		long tempoInicial = System.currentTimeMillis();
		if(menor < maior) {
			nComparacao++;
			int meio = (menor + maior) / 2;
			mergeSort(vetor, vetorAux, menor, meio);
			mergeSort(vetor, vetorAux, meio + 1, maior);
			intercalar(vetor, vetorAux, menor, meio, maior);
		}
		
		long tempoFinal = System.currentTimeMillis();
		long tempoTotal = tempoFinal - tempoInicial;
        
        long horas = tempoTotal / 3600000;
        long minutos = tempoTotal % 3600000 / 60000;
        long segundos = tempoTotal % 3600000 % 60000 / 1000;
        long milisegundos = tempoTotal % 3600000 % 60000 % 1000;
        
        System.out.println("Numero de Comparações: " + nComparacao  + "\nNumero de Movimentos: " + nMovimentos + "\nTempo de execução: "
        		+ horas + ":" + minutos + ":" + segundos + ":" + milisegundos + "\n");
	}

	public void intercalar(int[] vetor, int[] vetorAux, int menor, int meio, int maior) {
		for(int i = menor; i <= maior; i++) {
			vetorAux[i] = vetor[i];
		}
		int esq = menor;
		int dir = meio + 1;
		
		for(int i = menor; i <= maior; i++) {
			if(esq > meio) {
				nComparacao++;
				vetor[i] = vetorAux[dir++];
				nMovimentos++;
			}else if(dir > maior){
				nComparacao++;
				vetor[i] = vetorAux[esq++];
				nMovimentos++;
			}else if(vetorAux[esq] < vetorAux[dir]) {
				nComparacao++;
				vetor[i] = vetorAux[esq++];
				nMovimentos++;
			}else {
				nComparacao++;
				vetor[i] = vetorAux[dir++];
				nMovimentos++;
			}
		}
	}
}
