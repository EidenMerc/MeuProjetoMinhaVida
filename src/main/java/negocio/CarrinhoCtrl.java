package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import beans.*;
import negocio.*;

@ManagedBean
@ApplicationScoped
public class CarrinhoCtrl {
	private Produto prod = new Produto();
	private Pedido pedido = new Pedido();
	private List<Produto> listaProduto = new ArrayList<Produto>();

	public List<Produto> getListaProdutos() {
		return listaProduto;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProduto = listaProdutos;
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
		addcarrinho.setIpe_valorunit(produto.getPreco() * 1);
		addcarrinho.setIpe_subtotal(produto.getPreco() * 1);
		addcarrinho.setPed_id(pedido);

		pedido.getPedidos().add(addcarrinho);
	}
}
