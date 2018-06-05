package negocio;

import beans.*;

public class CarrinhoCtrl {
private Produto produto;
private Carrinho carrinho;

public CarrinhoCtrl() {
	this.carrinho = new Carrinho();
}

public void novoProduto() {
	this.produto = new Produto();
}
public Produto getProduto() {
	return produto;
}

public void setProduto(Produto produto) {
	this.produto = produto;
}

public Carrinho getCarrinho() {
	return carrinho;
}

public void setCarrinho(Carrinho carrinho) {
	this.carrinho = carrinho;
}

}
