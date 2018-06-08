package negocio;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import javax.faces.bean.SessionScoped;
import beans.*;
import persistencia.ProdutoDAO;

@ManagedBean
@SessionScoped
public class ProdutoCtrl implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final CopyOption[] StandarCopyOption = null;

	private Produto produto;

	private Path copy;

	public Produto getProduto() {
		if(produto == null) {
			produto = new Produto();
		}
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getListagem() {
		return ProdutoDAO.listagem("");
	}
	
	public String actionGravar(){
		if(produto.getId() == 0) {
			ProdutoDAO.inserir(produto);
			return actionInserir();
		} else {
			ProdutoDAO.alterar(produto);
			return "/admin/form_produto";
		}
	}
	public String actionInserir() {
		produto = new Produto();
		return "/admin/form_produto";
	}
	
	public String actionExcluir(Produto p){
		ProdutoDAO.excluir(p);
		return "/admin/lista_produto";
	}
	
	public String actionAlterar(Produto p){
		this.produto = p;
		return "/admin/form_produto";
	}
	
	/*	public void upload(FileUploadEvent evento) {
		try {
		UploadedFile arquivoUpload = evento.getFile();
		Path arquivoTemp = Files.createTempFile(null, null);
		Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandarCopyOption);
		produto.setCaminho(arquivoTemp.toString());
		} catch (IOException erro) {
			erro.printStackTrace();
		}
	}

	public void salvar() {

			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto produtoRetorno = produtoDAO.merge(produto);
			
			Path origem = Paths.get(produto.getCaminho());
			Path destino = Paths.get("C:/workspace/ProjMinhaLoja/src/main/webapp/resources/imagens" + produtoRetorno.getId() + ".png");



	}*/
}
