package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import beans.*;

@ManagedBean
@ApplicationScoped
public class CarrinhoCtrl {
	private Pedido pedido = new Pedido();

	private Produto prod = new Produto();
	private List<Produto> listaProdutos = new ArrayList<Produto>();

	public void addProduto() {
		listaProdutos.add(prod);
		this.prod = new Produto();
	}

	public Produto getProd() {
		return prod;
	}

	public void setProd(Produto prod) {
		this.prod = prod;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	 public void addCarrinho(Produto produto) {
		 Itens_pedido addcarrinho = new Itens_pedido();
		 
		 addcarrinho.setPro_id(produto);
		 addcarrinho.setIpe_qtde(1);
		 addcarrinho.setIpe_valorunit(produto.getPreco()*1);
		 addcarrinho.setIpe_subtotal(produto.getPreco()*1);
		 addcarrinho.setPed_id(pedido);
		 
		 pedido.getPedidos().add(addcarrinho);
	 }
}
