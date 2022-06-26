package tree;

import java.util.ArrayList;

public class No {

	Produto produto;
	ArrayList<No> filhos = new ArrayList<No>();
	
	public No(String produto) {
		super();
		this.produto = new Produto();
		this.produto.setProduto(produto);
	}

	public No(String produto, int quantidade, float valor) {
		super();
		this.produto = new Produto();
		this.produto.setProduto(produto);
		this.produto.setQuantidade(quantidade);
		this.produto.setValor(valor);
	}
	
}
