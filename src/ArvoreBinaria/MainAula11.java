package ArvoreBinaria;

import java.util.Random;

public class MainAula11 {
	//Arvore Secundaria
	static Arvore arvoreBalanceada = new Arvore();
	
	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		for(int i = 0; i < 100; i++) {
			arvore.inserir(nAleatorio());
		}
		//Ordenar os valores em ordem e inserir na arraylist para depois balancear
		arvore.emOrdem(arvore.raiz);
		
		//Algoritmo do vetor
		//Inserir valores da arraylist em ordem no vetor
		int vetor[] = new int[100];
		for(int i = 0; i < 100; i++) {
			vetor[i] = (int) arvore.vetor.get(i);
		}
		
		//Chamar o algoritmo do vetor para balancear a arvore usando a arvore secundaria
		AlgoritmoVetor.algVetor(vetor, 0, vetor.length - 1);
		
		
		//Mostrar na tela a ordenação em nivel para verificar se a arvore esta balanceada
		System.out.println("Algotirmo do Vetor ordenado em nivel:");
		MainAula11.arvoreBalanceada.emNivel(MainAula11.arvoreBalanceada.raiz);
		
		//Inserir mais 20 Valores na arvore balanceada pelo algoritmo do vetor
		for(int i = 0; i < 20; i++) {
			MainAula11.arvoreBalanceada.inserir(nAleatorio());
		}
		
		//Algoritmo DSW
		AlgoritmoDSW dsw = new AlgoritmoDSW();
		dsw.balanceBST(MainAula11.arvoreBalanceada.raiz);
		
		//Mostrar na tela a ordenação em nivel para verificar se a arvore esta balanceada
		System.out.println("\nAlgotirmo DSW ordenado em nivel:");
		MainAula11.arvoreBalanceada.emNivel(MainAula11.arvoreBalanceada.raiz);
	}
	
	
	public static int nAleatorio () {
		Random aleatorio = new Random();
		return aleatorio.nextInt(101);
	}
	
}
