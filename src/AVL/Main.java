package AVL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import ArvoreBinaria.Arvore;



public class Main {
	public static void main(String[] args) throws IOException {
		ArvoreAvl avl = new ArvoreAvl();
		Arvore arvoreBinaria = new Arvore();
		File arquivo = new File("Files/dados100_mil.txt");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		
		String res = "";
		
		while(br.ready()) {
			String linha = br.readLine();
			res += linha;
		}	
		br.close();
		
		String[] strVetor = res.replace("[", "").replace("]", "").split(",");
		int[] intVetor = new int[strVetor.length];
		for (int i = 0; i < intVetor.length; i++) {
			intVetor[i] = Integer.parseInt(strVetor[i].trim());
		}
		
		long tempoInicial = System.currentTimeMillis();
		for (int i = 0; i < intVetor.length; i++) {
			arvoreBinaria.inserir(intVetor[i]);
		}
		
		System.out.println("Em ordem:");
		arvoreBinaria.emOrdem(arvoreBinaria.raiz);
		System.out.println("\nPre ordem:");
		arvoreBinaria.preOrdem(arvoreBinaria.raiz);
		System.out.println("\nPos ordem:");
		arvoreBinaria.posOrdem(arvoreBinaria.raiz);
		
		long tempoFinal = System.currentTimeMillis();
        long tempoTotal = tempoFinal - tempoInicial;
        
        long horas = tempoTotal / 3600000;
        long minutos = tempoTotal % 3600000 / 60000;
        long segundos = tempoTotal % 3600000 % 60000 / 1000;
        long milisegundos = tempoTotal % 3600000 % 60000 % 1000;
        
        System.out.println("\n" + horas + ":" + minutos + ":" + segundos + ":" + milisegundos);
		
		
	}

}
