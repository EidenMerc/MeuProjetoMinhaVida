package negocio;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import beans.*;

@ManagedBean
@SessionScoped
public class Carrinho {
	
private ArrayList<Itens_pedido> itens_pedido = new ArrayList<Itens_pedido>();

public ArrayList<Itens_pedido> getItens_pedido() {
	return itens_pedido;
}

public void setItens_pedido(ArrayList<Itens_pedido> itens_pedido) {
	this.itens_pedido = itens_pedido;
}

public Itens_pedido getItens_pedido(int id) {
	Itens_pedido mp = null;
	for(beans.Itens_pedido i : itens_pedido) {
		if(i.getIpe_id() == id) {
			return i;
		}
	}
	return mp;
}

public void adiciona(Itens_pedido i) {
	if(getItens_pedido(i.getIpe_id()) == null) {
		itens_pedido.add(i);
	}else {
		i.setQtdCarrinho(i.getQtdCarrinho()+1);
	}
	i.diminuiEstoque();
}

public void remover(int id) {
	Itens_pedido i = getItens_pedido(id);
	
	if(i.getQtdCarrinho() > 1) {
		i.incrementaEstoque();
		i.setQtdCarrinho(i.getQtdCarrinho()-1);
	}else {
		itens_pedido.remove(i);
	}
}

public void removerGeral(int id) {
	Itens_pedido i = getItens_pedido(id);
	itens_pedido.remove(i);
	i.incrementaEstoque();
}

}
