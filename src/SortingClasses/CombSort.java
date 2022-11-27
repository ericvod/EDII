package SortingClasses;

public class CombSort {
	long nMovimentos = 0;
	long nComparacao = 0;

	 public int obterGap(int gap) {
	        gap = (int) (gap/(2));
	        if (gap < 1)
	            return 1;
	        return gap;
	    }
	 
	    public void combSort(int vetor[]) {
	    	long tempoInicial = System.currentTimeMillis();
	        int n = vetor.length;
	        int gap = n;
	        boolean swap = true;
	 
	        while (gap != 1 || swap == true) {
	            gap = obterGap(gap);
	            swap = false;
	 
	            for (int i = 0; i < n - gap; i++) {
	            	nComparacao++;
	                if (vetor[i] > vetor[i + gap]) {
	                    int temp = vetor[i];
	                    vetor[i] = vetor[i + gap];
	                    vetor[i + gap] = temp;
	                    swap = true;
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
