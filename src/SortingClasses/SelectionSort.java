package SortingClasses;

public class SelectionSort {
	public long nMovimentos = 0;
	public long nComparacao = 0;
	public String nome = "Selection Sort";
	public String tempoExecucao = "";
	
	public void selectionSort(int vetor[]) {
		long tempoInicial = System.currentTimeMillis();
	    for (int i = 0; i < vetor.length - 1; i++) {  
	    	int index = i;  
	        for (int j = i + 1; j < vetor.length; j++) {
	        	nComparacao++;
	            	if (vetor[j] < vetor[index]) {  
	                    index = j;
	                }  
	            }
	        if(vetor[index] != vetor[i]) {
		        int menorNumero = vetor[index];   
		        vetor[index] = vetor[i];  
		        vetor[i] = menorNumero;
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
