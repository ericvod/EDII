package SortingClasses;

import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {
	public long nMovimentos = 0;
	public long nComparacao = 0;
	public String nome = "Radix Sort";
	public String tempoExecucao = "";
	
	public void radixSort(int[] vetor) {
		long tempoInicial = System.currentTimeMillis();
		//iniciar configuração de um vetor Bucket com tamanho 20 e base 10
		int expMax = 1, tamanhoBucket = 20, base = 10;

		//criar uma linkedList para cada Bucket
		@SuppressWarnings("unchecked")
		Queue<Integer>[] bucks = new Queue[tamanhoBucket];
		for (int i = 0; i < tamanhoBucket; i++)
			bucks[i] = new LinkedList<>();

		//encontrar o expoente máximo usando log10
		for (int num : vetor) {
			int digMax = (int) Math.log10(Math.abs(num)) + 1;
			expMax = Math.max(expMax, digMax);
		}
		
		//vamos comecar no bit menos significativo até o mais significativo.we start at the least significant bit, and move up to the most significant bit.
		for (int exp = 1; exp <= Math.pow(base, expMax); exp *= base) {

			//para cada dado que adicionamos ao balde, vamos dividir o item pelo expoente e tirar a base dele.
			for (int dado : vetor) {
				int bucket = (dado / exp) % base;
				//ja que tambem consideramos valores negativos, 10 é adiciodado ao Bucket
				bucks[(bucket + base)].add(dado);
			}

			//esvaziaremos os Buckets parcialmente para começar a proxima rodada
			int idx = 0;
			for (Queue<Integer> bucket : bucks)
				while (!bucket.isEmpty()) { 
					vetor[idx++] = bucket.remove();
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
