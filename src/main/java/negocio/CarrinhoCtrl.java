package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import beans.FormaPgto;
import beans.Itens_pedido;
import beans.Pedido;
import beans.Produto;
import persistencia.FormaPgtoDAO;
import persistencia.PedidoDAO;
import persistencia.PessoaDAO;
import persistencia.ProdutoDAO;

@ManagedBean
@SessionScoped
public class CarrinhoCtrl {
	private Produto prod = new Produto();
	private Pedido pedido = new Pedido();
	private List<Produto> listaProduto = new ArrayList<Produto>();
	private int qdtItens = 0;
	private int somaQtdItens = 0;
	private int numeroParc;
	private FormaPgto formaDePagamento;

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

	public String getEmailDoUsuarioLogado() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user.getUsername());
		return user.getUsername();
	}

	public void addCarrinho(Produto produto) {
		Itens_pedido addcarrinho = new Itens_pedido();

		addcarrinho.setPro_id(produto);
		addcarrinho.setIpe_qtde(1);
		addcarrinho.setIpe_valorunit(produto.getPreco() * 1);
		addcarrinho.setIpe_subtotal(produto.getPreco() * 1);
		addcarrinho.setPed_id(pedido);

		this.somaQtdItens = this.listaProduto.size();
		pedido.getPedidos().add(addcarrinho);
		valorDoPedido();
	}

	public void actionPedido() {
		pedido.setPed_dataemissao(new Date());
		pedido.setPes_id(PessoaDAO.buscarPorEmail(getEmailDoUsuarioLogado()));
		pedido.setFpg_id(FormaPgtoDAO.pesqId(pedido.getFpg_id().getId()));
		pedido.setPed_dataautorizacao(new Date());
		pedido.setPed_status("COMPRADO");
		pedido.setPed_desconto(0);

		PedidoDAO.inserir(pedido);

	}

	public String actionRetornar(Pedido ped) {
		this.pedido = ped;
		return "/cliente/Pedidos";
	}

	public Produto getProd() {
		return prod;
	}

	public void setProd(Produto prod) {
		this.prod = prod;
	}

	public int getQdtItens() {
		return qdtItens;
	}

	public void setQdtItens(int qdtItens) {
		this.qdtItens = qdtItens;
	}

	public int getSomaQtdItens() {
		return somaQtdItens;
	}

	public void setSomaQtdItens(int somaQtdItens) {
		this.somaQtdItens = somaQtdItens;
	}

	public int getNumeroParc() {
		return numeroParc;
	}

	public void setNumeroParc(int numeroParc) {
		this.numeroParc = numeroParc;
	}

	public FormaPgto getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormaPgto formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public List<FormaPgto> getFormas() {
		return FormaPgtoDAO.listagem("");
	}
	
	public List<Pedido> getListagem() {
		return PedidoDAO.listagem("");
	}

	public void calcQuantidadeProduto(Itens_pedido item) {
		item.setIpe_subtotal(item.getIpe_qtde() * item.getIpe_valorunit());
		valorDoPedido();
		
	}

	public void valorDoPedido() {
		float valorTotal = 0;
		for (int i = 0; i < pedido.getPedidos().size(); i++) {
			valorTotal += pedido.getPedidos().get(i).getIpe_subtotal();
		}
		this.pedido.setPed_total(valorTotal);
	}

}
