package SortingClasses;

public class QuickSort {
	long nMovimentos = 0;
	long nComparacao = 0;
	  
	public void quickSort(int[] vetor, int menor, int maior) {
		long tempoInicial = System.currentTimeMillis();
	    if (menor < maior) {
	    	nComparacao++;
	        int p = particao(vetor, menor, maior);
	        quickSort(vetor, menor, p);
	        quickSort(vetor, p + 1, maior);
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
	
	public int particao(int[] vetor, int menor, int maior) {
	    int meio = (menor + maior) / 2;
		int pivot = vetor[meio]; 
	    int i = (menor - 1); 
	    int j = (maior + 1);
	    
	    while(true) {
	    	do {
	    		i++;
	    		nComparacao++;
	    	}while(vetor[i] < pivot);
	    	
	    	do {
	    		j--;
	    		nComparacao++;
	    	}while(vetor[j] > pivot);
	    	
	    	if(i >= j) {
	    		return j;
	    	}
	    	int aux = vetor[i];
	    	vetor[i] = vetor[j];
	    	vetor[j] = aux;
	    	nMovimentos++;
	    }
	}
}

