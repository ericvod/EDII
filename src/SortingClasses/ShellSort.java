package SortingClasses;

public class ShellSort {
	long nMovimentos = 0;
	long nComparacao = 0;

	public void shellSort(int[] vetor){
		long tempoInicial = System.currentTimeMillis();
		int h = 1;
		int n = vetor.length;
		
		while(h < n) {
			h = h * 3 + 1;
		}
		h = (int) Math.floor(h / 3);
		
		int elemento, j;
		
		while(h > 0) {
			for(int i = h; i < n; i++) {
				nComparacao++;
				elemento = vetor[i];
				j = i;
				while(j >= h && vetor[j - h] > elemento) {
					nComparacao++;
					vetor[j] = vetor [j - h];
					nMovimentos++;
					j = j - h;
				}
				vetor[j] = elemento;
			}
			h = h / 2;
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
