package SortingClasses;

public class BogoSort {
	public long nMovimentos = 0;
	public long nComparacao = 0;
	public String nome = "Bogo Sort";
	public String tempoExecucao = "";
	
	public void bogoSort(int vetor[]) {
		long tempoInicial = System.currentTimeMillis();
        while (verificarOrdenacao(vetor) == false) {
            embaralhar(vetor);
        }
        
        long tempoFinal = System.currentTimeMillis();
        long tempoTotal = tempoFinal - tempoInicial;
        
        long horas = tempoTotal / 3600000;
        long minutos = tempoTotal % 3600000 / 60000;
        long segundos = tempoTotal % 3600000 % 60000 / 1000;
        long milisegundos = tempoTotal % 3600000 % 60000 % 1000;
        
        tempoExecucao = horas + ":" + minutos + ":" + segundos + ":" + milisegundos;
    }
 
    void embaralhar(int vetor[]) {
         for (int i = 0; i <= vetor.length - 1; i++) {
        	 nComparacao++;
             troca(vetor, i, (int)(Math.random()*(i + 1)));
             }
    }
 
    void troca(int vetor[], int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
        nMovimentos++;
    }
 
    boolean verificarOrdenacao(int vetor[]) {
        for (int i = 1; i < vetor.length; i++) {
        	nComparacao++;
            if (vetor[i] < vetor[i - 1]) {
                return false;
                }
        }
        return true;
    }

}
