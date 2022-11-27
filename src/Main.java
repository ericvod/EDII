import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import SortingClasses.BogoSort;
import SortingClasses.InsertionSort;
import SortingClasses.SelectionSort;

public class Main {
	public static void main(String[] args) throws IOException {
		InsertionSort sort = new InsertionSort();
		File arquivo = new File("Files/novoArquivo.txt");
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
		
		sort.insertionSort(intVetor);
		
		File novoArquivo = new File("Files/novoArquivo2.txt");
		novoArquivo.delete();
		novoArquivo.createNewFile();
		FileWriter fw = new FileWriter(novoArquivo);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Nome do Aluno: Eric Dourado");
		bw.newLine();
		bw.write("Nome do algoritmo: " + sort.nome);
		bw.newLine();
		bw.write("Tempo de Execução: " + sort.tempoExecucao);
		bw.newLine();
		bw.write("Quantidade de comparações: " + sort.nComparacao);
		bw.newLine();
		bw.write("Quantidade de Movimentações: " + sort.nMovimentos);
		bw.newLine();
		bw.write(Arrays.toString(intVetor));
		bw.close();
		System.out.println("Pronto");
	}
}