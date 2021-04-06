package br.com.cotiinformatica.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.models.ProdutoGetResponse;
import br.com.cotiinformatica.services.ProdutoService;

@Controller
public class ProdutoGetController {
	
	@Autowired
	private ProdutoService service;
	
	@CrossOrigin
	@RequestMapping(value = "/api/produtos", method = RequestMethod.GET)
	@ResponseBody
	public List<ProdutoGetResponse> getProdutos() {
		
		List<ProdutoGetResponse> produtos = new ArrayList<ProdutoGetResponse>();
		
		try {
						
			for(Produto item : service.findAll()) {
				
				ProdutoGetResponse response = new ProdutoGetResponse();
				response.setIdProduto(item.getIdProduto());
				response.setNome(item.getNome());
				response.setDescricao(item.getDescricao());
				response.setQuantidade(item.getQuantidade());
				response.setPreco(item.getPreco());
				
				produtos.add(response);
			}
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return produtos;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/produtos/{idProduto}", method = RequestMethod.GET)
	@ResponseBody
	public ProdutoGetResponse getProduto(@PathVariable("idProduto") Integer idProduto) {
		
		try {
			
			Produto produto = service.findById(idProduto);
			
			if(produto != null) {
				
				ProdutoGetResponse response = new ProdutoGetResponse();
				
				response.setIdProduto(produto.getIdProduto());
				response.setNome(produto.getNome());
				response.setDescricao(produto.getDescricao());
				response.setQuantidade(produto.getQuantidade());
				response.setPreco(produto.getPreco());
				
				return response;
			}else {
				throw new Exception("Produto não encontrado!");
			}
			
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return null;
	}
}
