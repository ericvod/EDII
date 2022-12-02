package SortingClasses;

public class CocktailSort {
	public long nMovimentos = 0;
	public long nComparacao = 0;
	public String nome = "Cocktail Sort";
	public String tempoExecucao = "";
	
	public void cocktailSort(int vetor[]) {
		long tempoInicial = System.currentTimeMillis();
        boolean swapped = true;
        int start = 0;
        int end = vetor.length;
 
        while (swapped == true) {   
            swapped = false;
 
            for (int i = start; i < end - 1; ++i) {
            	nComparacao++;
                if (vetor[i] < vetor[i + 1]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                    swapped = true;
                    nMovimentos++;
                }
            }
 
            if (swapped == false) {
                break;
                }

            swapped = false;
            end -= 1;
 

            for (int i = end - 1; i >= start; i--) {
            	nComparacao++;
                if (vetor[i] < vetor[i + 1]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                    swapped = true;
                    nMovimentos++;
                }
            }
            start += 1;
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
