package SortingClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
	public long nMovimentos = 0;
	public long nComparacao = 0;
	public String nome = "Bucket Sort";
	public String tempoExecucao = "";
	
	public void bucketSort(int[] arr) {
		long tempoInicial = System.currentTimeMillis();
	    int max = max(arr);
	    int min = min(arr);

	    int numberOfBuckets = max - min + 1;
	    List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);
	    for (int i = 0; i < numberOfBuckets; ++i) {
	      buckets.add(new ArrayList<>());
	    }

	    for (int value : arr) {
	      int hash = hash(value, min, numberOfBuckets);
	      buckets.get(hash).add(value);
	    }

	    for (List<Integer> bucket : buckets) {
	      Collections.sort(bucket);
	      nComparacao++;
	    }

	    int index = 0;
	    for (List<Integer> bucket : buckets) {
	      for (int value : bucket) {
	        arr[index++] = value;
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

	  private static int hash(int elem, int min, int numberOfBucket) {
	    return (elem - min) / numberOfBucket;
	  }
	  
	  public static int max(int[] arr) {
	    int max = arr[0];
	    for (int value : arr) {
	      if (value > max) {
	        max = value;
	      }
	    }
	    return max;
	  }
	  
	  public static int min(int[] arr) {
	    int min = arr[0];
	    for (int value : arr) {
	      if (value < min) {
	        min = value;
	      }
	    }
	    return min;
	  }
	 
}
