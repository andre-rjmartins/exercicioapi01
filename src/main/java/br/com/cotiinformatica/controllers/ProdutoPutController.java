package br.com.cotiinformatica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.models.ProdutoPutRequest;
import br.com.cotiinformatica.models.ProdutoPutResponse;
import br.com.cotiinformatica.services.ProdutoService;

@Controller
public class ProdutoPutController {
	
	@Autowired
	private ProdutoService service;
	
	@CrossOrigin
	@RequestMapping(value = "/api/produtos", method = RequestMethod.PUT)
	@ResponseBody
	public ProdutoPutResponse putProduto(@RequestBody ProdutoPutRequest request) {
		
		ProdutoPutResponse response = new ProdutoPutResponse();
		
		try {
			
			Produto produto = service.findById(request.getIdProduto());
			
			if(produto != null) {
				produto.setNome(request.getNome());
				produto.setDescricao(request.getDescricao());
				produto.setQuantidade(request.getQuantidade());
				produto.setPreco(request.getPreco());
				
				service.createOrUpdate(produto);
				
				response.setMensagem("Produto foi atualizado com sucesso!");
			}else {
				throw new Exception("Produto não encontrado!");
			}
		}
		catch(Exception e) {
			response.setMensagem("Erro: " + e.getMessage());
		}
		
		return response;
	}
}
