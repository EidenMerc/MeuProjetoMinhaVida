package beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import beans.Pedido;

@Entity
@Table(name = "itens_pedido")
public class Itens_pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ipe_id")
	private int ipe_id;

	@ManyToOne
	@JoinColumn(name = "ped_id")
	private Pedido ped_id;

	@ManyToOne
	@JoinColumn(name = "pro_id")
	private Produto pro_id;

	@Column(name = "ipe_qtde")
	private double ipe_qtde;

	@Column(name = "ipe_valorunit")
	private double ipe_valorunit;

	@Column(name = "ipe_subtotal")
	private double ipe_subtotal;



	@Column(name = "count")
	private static int count = 0;

	public Itens_pedido(int ipe_id, Pedido ped_id, Produto pro_id, double ipe_qtde, double ipe_valorunit,
			double ipe_subtotal) {
		super();
		this.ipe_id = ipe_id;
		this.ped_id = ped_id;
		this.pro_id = pro_id;
		this.ipe_qtde = ipe_qtde;
		this.ipe_valorunit = ipe_valorunit;
		this.ipe_subtotal = ipe_subtotal;

	}

	public Itens_pedido() {
	}

	public int getIpe_id() {
		return ipe_id;
	}

	public void setIpe_id(int ipe_id) {
		this.ipe_id = ipe_id;
	}

	public double getIpe_qtde() {
		return ipe_qtde;
	}

	public void setIpe_qtde(double ipe_qtde) {
		this.ipe_qtde = ipe_qtde;
	}

	public double getIpe_valorunit() {
		return ipe_valorunit;
	}

	public void setIpe_valorunit(double ipe_valorunit) {
		this.ipe_valorunit = ipe_valorunit;
	}

	public double getIpe_subtotal() {
		return ipe_subtotal;
	}

	public void setIpe_subtotal(double ipe_subtotal) {
		this.ipe_subtotal = ipe_subtotal;
	}

	public Pedido getPed_id() {
		return ped_id;
	}

	public void setPed_id(Pedido ped_id) {
		this.ped_id = ped_id;
	}

	public Produto getPro_id() {
		return pro_id;
	}

	public void setPro_id(Produto pro_id) {
		this.pro_id = pro_id;
	}


}
