package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ped_id")
	private int ped_id;
	
	@ManyToOne
	@JoinColumn(name = "pes_id")
	private Pessoa pes_id;
	
	@ManyToOne
	@JoinColumn(name = "fpg_id")
	private FormaPgto fpg_id = new FormaPgto();
	
	@Column(name = "ped_dataemissao")
	private Date ped_dataemissao;
	
	@Column(name = "ped_status")
	private String ped_status;
	
	@Column(name = "ped_dataautorizacao")
	private Date ped_dataautorizacao;
	
	@Column(name = "ped_total")
	private double ped_total;
	
	@Column(name = "ped_desconto")
	private double ped_desconto;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "ped_id",cascade = CascadeType.ALL)
	private List<Itens_pedido> pedidos = new ArrayList<>();
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	public Pedido(int ped_id, Pessoa pes_id, FormaPgto fpg_id, Date ped_dataemissao, String ped_status,
			Date ped_dataautorizacao, double ped_total, double ped_desconto) {

		this.ped_id = ped_id;
		this.pes_id = pes_id;
		this.fpg_id = fpg_id;
		this.ped_dataemissao = ped_dataemissao;
		this.ped_status = ped_status;
		this.ped_dataautorizacao = ped_dataautorizacao;
		this.ped_total = ped_total;
		this.ped_desconto = ped_desconto;
	}
	public int getPed_id() {
		return ped_id;
	}
	public void setPed_id(int ped_id) {
		this.ped_id = ped_id;
	}
	public Date getPed_dataemissao() {
		return ped_dataemissao;
	}
	public void setPed_dataemissao(Date ped_dataemissao) {
		this.ped_dataemissao = ped_dataemissao;
	}
	public String getPed_status() {
		return ped_status;
	}
	public void setPed_status(String ped_status) {
		this.ped_status = ped_status;
	}
	public Date getPed_dataautorizacao() {
		return ped_dataautorizacao;
	}
	public void setPed_dataautorizacao(Date ped_dataautorizacao) {
		this.ped_dataautorizacao = ped_dataautorizacao;
	}
	public double getPed_total() {
		return ped_total;
	}
	public void setPed_total(double ped_total) {
		this.ped_total = ped_total;
	}
	public double getPed_desconto() {
		return ped_desconto;
	}
	public void setPed_desconto(double ped_desconto) {
		this.ped_desconto = ped_desconto;
	}
	public Pessoa getPes_id() {
		return pes_id;
	}
	public void setPes_id(Pessoa pes_id) {
		this.pes_id = pes_id;
	}
	public FormaPgto getFpg_id() {
		return fpg_id;
	}
	public void setFpg_id(FormaPgto fpg_id) {
		this.fpg_id = fpg_id;
	}
	public List<Itens_pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Itens_pedido> pedidos) {
		this.pedidos = pedidos;
	}

	
	
}