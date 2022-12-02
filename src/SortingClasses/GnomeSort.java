package SortingClasses;

public class GnomeSort {
	public long nMovimentos = 0;
	public long nComparacao = 0;
	public String nome = "Gnome Sort";
	public String tempoExecucao = "";
	
	public void gnomeSort(int vetor[], int n) {
		long tempoInicial = System.currentTimeMillis();
		int index = 0;
	 
		while (index < n) {
			if (index == 0) {
				index++;
			}
			if (vetor[index] <= vetor[index - 1]) {
				index++;
				nComparacao++;
			}else {
				int aux = vetor[index];
				vetor[index] = vetor[index - 1];
				vetor[index - 1] = aux;
			    index--;
			    nMovimentos++;
			}
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
