package br.com.cotiinformatica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.models.ProdutoPostRequest;
import br.com.cotiinformatica.models.ProdutoPostResponse;
import br.com.cotiinformatica.services.ProdutoService;

@Controller
public class ProdutoPostController {
	
	@Autowired
	private ProdutoService service;
	
	@CrossOrigin
	@RequestMapping(value = "/api/produtos", method = RequestMethod.POST)
	@ResponseBody
	public ProdutoPostResponse postProduto(@RequestBody ProdutoPostRequest request) {
		
		ProdutoPostResponse response = new ProdutoPostResponse();
		
		try {
			
			Produto produto = new Produto();
			produto.setNome(request.getNome());
			produto.setDescricao(request.getDescricao());
			produto.setQuantidade(request.getQuantidade());
			produto.setPreco(request.getPreco());
			
			service.createOrUpdate(produto);
			
			response.setMensagem("Produto cadastrado com sucesso!");
		}
		catch(Exception e) {
			response.setMensagem("Erro: " + e.getMessage());
		}
		
		return response;
	}
}
