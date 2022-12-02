package SortingClasses;

import java.util.Arrays;

public class CountingSort {
	public long nMovimentos = 0;
	public long nComparacao = 0;
	public String nome = "Counting Sort";
	public String tempoExecucao = "";
	
	public void countingSort(int[] vetor) {
		long tempoInicial = System.currentTimeMillis();
        int max = Arrays.stream(vetor).max().getAsInt();
        int min = Arrays.stream(vetor).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[vetor.length];
        for (int i = 0; i < vetor.length; i++) {
            count[vetor[i] - min]++;
        }
 
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
 
        for (int i = vetor.length - 1; i >= 0; i--) {
            output[count[vetor[i] - min] - 1] = vetor[i];
            count[vetor[i] - min]--;
        }
 
        for (int i = 0; i < vetor.length; i++) {
        	vetor[i] = output[i];
        	nMovimentos++;
        }
        
        long tempoFinal = System.currentTimeMillis();
	    long tempoTotal = tempoFinal - tempoInicial;
	        
        long horas = tempoTotal / 3600000;
        long minutos = tempoTotal % 3600000 / 60000;
        long segundos = tempoTotal % 3600000 % 60000 / 1000;
        long milisegundos = tempoTotal % 3600000 % 60000 % 1000;
        
        tempoExecucao = horas + ":" + minutos + ":" + segundos + ":" + milisegundos;
    }
}
