package RubroNegra;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Arvore arvoreRN = new Arvore();

		// Adiciona 1000 valores na arvore Rubro-negra
		for (int i = 0; i < 1000; i++) {
			arvoreRN.inserir(Main.nAleatorio());
		}
		// Inicio para Marcar o tempo para a impressão de todos os dados
		long tempoInicial = System.currentTimeMillis();
		// Imprimir a arvore em ordem, pre ordem e pos ordem
		System.out.println("Em ordem:");
		arvoreRN.emOrdem(arvoreRN.raiz);
		System.out.println("\nPre ordem:");
		arvoreRN.preOrdem(arvoreRN.raiz);
		System.out.println("\nPos ordem:");
		arvoreRN.posOrdem(arvoreRN.raiz);

		// Remove os numeros Primos
		for (int i = 0; i < 1000; i++) {
			if (Main.ePrimo(i)) {
				arvoreRN.remove(i);
			}
		}

		// Imprimir os dados novamente apos a retirada dos numeros primos
		System.out.println("\n\nSem valores Primos:");
		System.out.println("Em ordem:");
		arvoreRN.emOrdem(arvoreRN.raiz);
		System.out.println("\nPre ordem:");
		arvoreRN.preOrdem(arvoreRN.raiz);
		System.out.println("\nPos ordem:");
		arvoreRN.posOrdem(arvoreRN.raiz);

		// Inicio para Marcar o tempo para a impressão de todos os dados
		long tempoFinal = System.currentTimeMillis();
		long tempoTotal = tempoFinal - tempoInicial;

		long horas = tempoTotal / 3600000;
		long minutos = tempoTotal % 3600000 / 60000;
		long segundos = tempoTotal % 3600000 % 60000 / 1000;
		long milisegundos = tempoTotal % 3600000 % 60000 % 1000;
		// Mostrar o tempo na tela
		System.out.println("\nTempo de execução: " + horas + ":" + minutos + ":" + segundos + ":" + milisegundos);

	}

	public static int nAleatorio() {
		Random aleatorio = new Random();
		return aleatorio.nextInt(1001);
	}

	public static boolean ePrimo(int numero) {
		for (int j = 2; j < numero; j++) {
			if (numero % j == 0)
				return false;
		}
		return true;
	}

}
