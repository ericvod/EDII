package ArvoreBinaria;

import java.util.Random;

public class MainAula10 {
	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		for (int i = 0; i < 20; i++) {
			arvore.inserir(MainAula10.nAleatorio());
		}
		System.out.println("Em ordem:");
		arvore.emOrdem(arvore.raiz);
		System.out.println("\nPre ordem:");
		arvore.preOrdem(arvore.raiz);
		System.out.println("\nPos ordem:");
		arvore.posOrdem(arvore.raiz);
		System.out.println("\nEm nivel:");
		arvore.emNivel(arvore.raiz);
		
		int i = 0;
		while(true) {
			if(arvore.remover(MainAula10.nAleatorio()) == true) {
				i++;
			}else if(i == 5) {
				break;
			}
		}
		
		System.out.println("\n\nEm ordem:");
		arvore.emOrdem(arvore.raiz);
		System.out.println("\nPre ordem:");
		arvore.preOrdem(arvore.raiz);
		System.out.println("\nPos ordem:");
		arvore.posOrdem(arvore.raiz);
		System.out.println("\nEm nivel:");
		arvore.emNivel(arvore.raiz);
		
	}
	
	public static int nAleatorio () {
		Random aleatorio = new Random();
		return aleatorio.nextInt(101);
	}

}
