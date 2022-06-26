package tree;

import java.util.ArrayList;
import java.util.Iterator;

public class Arvore {

	No raiz;
	No pai;
	private float valor = 0;
	private ArrayList<No> folhas = new ArrayList<No>();

	public void inserir(No filho) {
		if (raiz == null) {
			raiz = filho;
			return;
		}
		pai.filhos.add(filho);
		System.out.println("Filho adicionado!\n");
	}

	public void inserir(No filho, No pai) {
		pai.filhos.add(filho);
		this.pai = pai;
		System.out.println("Filho adicionado!\n");
	}

	public void percorrer(No raiz) {

		Iterator<No> iterator = raiz.filhos.iterator();

		while (iterator.hasNext()) {
			No n = iterator.next();
			System.out.println(n.produto.getProduto());

			if (!n.filhos.isEmpty()) {
				percorrer(n);
			}
		}
	}

	public void setFolhas(No raiz) {

		Iterator<No> iterator = raiz.filhos.iterator();

		while (iterator.hasNext()) {
			No n = iterator.next();

			if (n.filhos.isEmpty()) {
				folhas.add(n);
			}
			setFolhas(n);
		}
	}

	public void getFolhas() {
		for (No folha : folhas) {
			System.out.println(folha.produto.getProduto());
		}
	}

	public void setValor(No raiz) {

		Iterator<No> iterator = raiz.filhos.iterator();

		while (iterator.hasNext()) {
			No n = iterator.next();
			valor += n.produto.getValor() * n.produto.getQuantidade();

			if (!n.filhos.isEmpty()) {
				setValor(n);
			}
		}
	}

	public void getValor() {
		System.out.printf("R$ %.2f", valor);
	}
}
