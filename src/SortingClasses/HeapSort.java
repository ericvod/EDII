package SortingClasses;

public class HeapSort {
	long nMovimentos = 0;
	long nComparacao = 0;
	
	public void heapSort(int[] vetor){
		long tempoInicial = System.currentTimeMillis();
		int n = vetor.length;
		for (int i = (n / 2) - 1; i >= 0; i--) {
			aplicarHeap(vetor, n, i);
		}
		
		for (int i = n - 1; i > 0; i--) {
			int aux = vetor[0];
			vetor[0] = vetor[i];
			vetor[i] = aux;
			nMovimentos++;
			aplicarHeap(vetor, i, 0);
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

	public void aplicarHeap(int[] vetor, int n, int i) {
		int raiz = i;
		int esquerda = (2 * i) + 1;
		int direita = (2 * i) + 2;
		
		if(esquerda < n && vetor[esquerda] > vetor[raiz]) {
			raiz = esquerda;
			nComparacao++;
		}
		
		if(direita < n && vetor[direita] > vetor[raiz]) {
			raiz = direita;
			nComparacao++;
		}
		
		if(raiz != i) {
			int aux = vetor[i];
			vetor[i] = vetor[raiz];
			vetor[raiz] = aux;
			nMovimentos++;
			aplicarHeap(vetor, n, raiz);
		}	
	}
}
