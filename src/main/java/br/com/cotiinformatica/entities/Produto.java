package br.com.cotiinformatica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduto")
	private Integer idProduto;
	
	@Column(name = "nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "descricao", length = 1000, nullable = false)
	private String descricao;
	
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name = "preco", nullable = false)
	private Double preco;

	public Produto() {
		// TODO Auto-generated constructor stub
	}
	
	public Produto(Integer idProduto, String nome, String descricao, Integer quantidade, Double preco) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", descricao=" + descricao + ", quantidade="
				+ quantidade + ", preco=" + preco + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Produto) {
			
			Produto produto = (Produto) obj;
			
			return this.idProduto.equals(produto.getIdProduto());
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.idProduto.hashCode();
	}
}
