package SortingClasses;

public class TimSort {
	public long nMovimentos = 0;
	public long nComparacao = 0;
	public String nome = "Tim Sort";
	public String tempoExecucao = "";
	
	static int MIN_MERGE = 32;
	
	public void timSort(int[] vetor, int n) {
		long tempoInicial = System.currentTimeMillis();
        int minRun = minRunLength(MIN_MERGE);
       
        for (int i = 0; i < n; i += minRun) {
            insertionSort(vetor, i, Math.min((i + MIN_MERGE - 1), (n - 1)));
        }
        
        for (int size = minRun; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1),
                                     (n - 1));
 
                  if(mid < right) {
                    merge(vetor, left, mid, right);
                  }
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
	

	
	public int minRunLength(int n) {
        assert n >= 0;
        int r = 0;
        while (n >= MIN_MERGE)
        {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }
 
	
    public void insertionSort(int[] vetor, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int chave = vetor[i];
            int j = i - 1;
            int l = 0;
            nComparacao++;
            while (j >= left && vetor[j] > chave) {
            	if(l != 0) {
            		nComparacao++;
            	}
            	vetor[j + 1] = vetor[j];
                nMovimentos++;
                l++;
                j--;
            }
            vetor[j + 1] = chave;
            l = 0;
        }
    }
 
    public void merge(int[] vetor, int l, int m, int r) {
    	
        int len1 = m - l + 1;
        int	len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int x = 0; x < len1; x++) {
            left[x] = vetor[l + x];
        }
        for (int x = 0; x < len2; x++) {
            right[x] = vetor[m + 1 + x];
        }
 
        int i = 0;
        int j = 0;
        int k = l;
 
        while (i < len1 && j < len2) {
        	nComparacao++;
            if (left[i] <= right[j]) {
            	vetor[k] = left[i];
                i++;
                nMovimentos++;
            }
            else {
            	vetor[k] = right[j];
                j++;
                nMovimentos++;
                
            }
            k++;
        }
 
        while (i < len1) {
        	vetor[k] = left[i];
            k++;
            i++;
            nComparacao++;
            nMovimentos++;
        }
 
        while (j < len2) {
        	vetor[k] = right[j];
            k++;
            j++;
            nComparacao++;
            nMovimentos++;
        }
    }

}
