package mainProgram;

import java.util.InputMismatchException;
import java.util.Scanner;

import custom.Exceptions.OutOfBoundsException;
import ordenacaoVetores.OrdenacaoInsercao;
import ordenacaoVetores.OrdenacaoSelecao;

public class Lista03 {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		while(true){
			
			System.out.println("Informe qual exercicio voc� deseja rodar:\n"
					+ "1  -> Ordena��o de Algoritmos pelo m�todo Selecao\n"
					+ "2  -> Ordena��o de Algoritmos pelo m�todo Insercao\n");

			int opcao = leituraOpcao(1, 2);
			escolherAtividade(opcao);
		}
	}

	/*<--------------------------------------------------------------------------------------->*/


	public static void escolherAtividade (int opcao){

		double tempoInicial = System.currentTimeMillis();
		int tamanho = requisitarTamanho();

		switch (opcao){
		case 1:

			//int[] vetor = {1,2,3,4,5,6,7,8,9,10};
			//int[] vetor = {10,9,8,7,6,5,4,3,2,1};
			//OrdenacaoSelecao selecao = new OrdenacaoSelecao(vetor);

			OrdenacaoSelecao selecao = new OrdenacaoSelecao(tamanho);
			selecao.getVetor().preencherAleatorio(1000);

			System.out.print("\nVetor aleatorio: ");
			selecao.getVetor().printVetor();  

			selecao.ordenar(); 
			System.out.print("Vetor ordenado: ");
			selecao.getVetor().printVetor(); 

			System.out.printf("\nNumero de comparacoes: %d\nNumero de trocas: %d", selecao.getComparacoes(), selecao.getTrocas());
			System.out.println("\nDuracao da ordenacao: " + (System.currentTimeMillis() - tempoInicial) + " ms.");
			break;

		case 2:

			//int[] vetor = {1,2,3,4,5,6,7,8,9,10};
			//int[] vetor = {10,9,8,7,6,5,4,3,2,1};
			//OrdenacaoSelecao insercao = new OrdenacaoSelecao(vetor);

			OrdenacaoInsercao insercao = new OrdenacaoInsercao(tamanho);
			insercao.getVetor().preencherAleatorio(1000);

			System.out.print("\nVetor aleatorio: ");
			insercao.getVetor().printVetor();  

			insercao.ordenar(); 
			System.out.print("Vetor ordenado: ");
			insercao.getVetor().printVetor(); 

			System.out.printf("\nNumero de comparacoes: %d\nNumero de trocas: %d", insercao.getComparacoes(), insercao.getTrocas());
			System.out.println("\nDuracao da ordenacao: " + (System.currentTimeMillis() - tempoInicial) + " ms.");
			break;
		}
		
		System.out.println("\n");
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int leituraOpcao(int min, int max) {

		int exercicio = 0;
		boolean repeate = true;

		while (repeate == true){

			try {

				System.out.print("Opcao: ");
				exercicio = entrada.nextInt();					

				if (exercicio < min || exercicio > max){
					throw new OutOfBoundsException();
				}

				repeate = false;
			} 
			catch (OutOfBoundsException e){}
			catch (InputMismatchException e){ System.out.println("Voc� inseriu um caractere invalido. Insira um exerc�cio v�lido"); entrada.next();}
			catch(Exception e){ e.printStackTrace();}

		}

		return exercicio;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int requisitarTamanho(){

		int tamanho = 0;

		while (true){

			try {

				System.out.print("Informe o tamanho do vetor: ");
				tamanho = entrada.nextInt();

				if (tamanho < 5 || tamanho > 13000){
					throw new OutOfBoundsException();
				}

				return tamanho;
			} 
			catch (OutOfBoundsException e){}
			catch (InputMismatchException e){ System.out.println("Voc� inseriu um caractere invalido. Insira um exerc�cio v�lido"); entrada.next();}
			catch(Exception e){ e.printStackTrace();}
		}
	}
}
