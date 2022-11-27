package SortingClasses;

public class InsertionSort {
	public long nMovimentos = 0;
	public long nComparacao = 0;
	public String nome = "InsertionSort Sort";
	public String tempoExecucao = "";
	
    public void insertionSort(int vetor[]) {
    	long tempoInicial = System.currentTimeMillis();
        int tamanho = vetor.length;
        for (int j = 1; j < tamanho; j++) {  
        	nComparacao++;
            int chave = vetor[j];
            int l = 0;
            int i = j - 1;
            while ((i >= 0) && (vetor[i] < chave)) {
                vetor[i + 1] = vetor[i];  
                i--;
                if(l > 0) {
                	nComparacao++;
                }
                l++;
                nMovimentos++;
            }  
            vetor[i + 1] = chave;
            l = 0;
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
