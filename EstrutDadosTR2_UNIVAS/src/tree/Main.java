package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

//	 ArrayLists onde ir� conter os dados que ser�o passados como par�metros para os construtores.
	static ArrayList<String> produtos = new ArrayList<String>();
	static ArrayList<Integer> quantidades = new ArrayList<Integer>();
	static ArrayList<Float> valores = new ArrayList<Float>();

	public static void main(String[] args) {

		Arvore arvore = new Arvore();
		Scanner input = new Scanner(System.in);

		getParametros(input.next());
		
		/*
		 * 
		 * Teclas,101,1.50;Carca�a,2,19.50;PCB,1,50;Pl�stico,3,0.40;Tinta,1,0.20;Pl�stico,10,5;Alum�nio,5,10;Sil�cio,10,3;Cobre,7,3;Vidro,3,1
		 * 
		 */
		
		input.close();

//		Iterator para cada ArrayList, cujo valores contidos ser�o usados como par�metros.
		Iterator<String> itString = produtos.iterator();
		Iterator<Integer> itInteger = quantidades.iterator();
		Iterator<Float> itFloat = valores.iterator();

//		Montagem da �rvore pt. 1:
//				Cria��o dos n�s.
		No raiz = new No("Teclado");
//		No no = new No(Produto, Quantidade, Valor);
		No a = new No(itString.next(), itInteger.next(), itFloat.next());
		No b = new No(itString.next(), itInteger.next(), itFloat.next());
		No c = new No(itString.next(), itInteger.next(), itFloat.next());

		No a1 = new No(itString.next(), itInteger.next(), itFloat.next());
		No a2 = new No(itString.next(), itInteger.next(), itFloat.next());

		No b1 = new No(itString.next(), itInteger.next(), itFloat.next());
		No b2 = new No(itString.next(), itInteger.next(), itFloat.next());

		No c1 = new No(itString.next(), itInteger.next(), itFloat.next());
		No c2 = new No(itString.next(), itInteger.next(), itFloat.next());
		No c3 = new No(itString.next(), itInteger.next(), itFloat.next());
		
//		Cria��o manual dos n�s.
//		No a = new No("Teclas", 101, 1.50f);
//		No b = new No("Carca�a", 2, 19.50f);
//		No c = new No("PCB", 1, 50);
//
//		No a1 = new No("Pl�stico", 3, 0.40f);
//		No a2 = new No("Tinta", 1, 0.20f);
//
//		No b1 = new No("Pl�stico", 10, 5);
//		No b2 = new No("Alum�nio", 5, 10);
//
//		No c1 = new No("Sil�cio", 10, 3);
//		No c2 = new No("Cobre", 7, 3);
//		No c3 = new No("Vidro", 3, 1);
		
//		Montagem da �rvore pt. 2:
//		Inser��o dos n�s.
		arvore.inserir(raiz);

		arvore.inserir(a, raiz);
		arvore.inserir(b, raiz);
		arvore.inserir(c, raiz);

		arvore.inserir(a1, a);
		arvore.inserir(a2, a);

		arvore.inserir(b1, b);
		arvore.inserir(b2, b);

		arvore.inserir(c1, c);
		arvore.inserir(c2, c);
		arvore.inserir(c3, c);
		
//		N�s-folha:
		System.out.println("~ Mat�rias-primas");
		arvore.setFolhas(raiz);
		arvore.getFolhas();

//		Custo total:
		System.out.println("\n~ Valor total");
		arvore.setValor(raiz);
		arvore.getValor();
	}

//	Separa os dados brutos recebidos do usu�rio em uma String contendo 3 valores:
	private static void getParametros(String next) {
//		"(Produto), (Quantidade), (Valor)".
		String[] parametrosBrutos = next.split(";");
		for (String parametroBruto : parametrosBrutos) {
			String[] parametros = parametroBruto.split(",");
			int index = 0;
//			Cria os par�metros para o construtor dos n�s nos respectivos tipos,
//			separando-os novamente e adicionando-os aos respectivos ArrayLists.
			produtos.add(parametros[index]);
			index++;
			quantidades.add(Integer.parseInt(parametros[index]));
			index++;
			valores.add(Float.parseFloat(parametros[index]));
			index++;
		}

	}

}
