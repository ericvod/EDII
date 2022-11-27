package SortingClasses;

public class BubbleSort {
	long nMovimentos = 0;
	long nComparacao = 0;
	
	public void bubbleSort(int vetor[]) {
		long tempoInicial = System.currentTimeMillis();
		for(int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length - 1; j++) {
				nComparacao++;
				if(vetor[j] > vetor[j + 1]) {
					int aux = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = aux;
					nMovimentos++;
				}
			}
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
}
