package br.com.cotiinformatica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.models.ProdutoDeleteResponse;
import br.com.cotiinformatica.services.ProdutoService;

@Controller
public class ProdutoDeleteController {
	
	@Autowired
	private ProdutoService service;
	
	@CrossOrigin
	@RequestMapping(value = "/api/produtos/{idProduto}", method = RequestMethod.DELETE)
	@ResponseBody
	public ProdutoDeleteResponse deleteProduto(@PathVariable("idProduto") Integer idProduto) {
		
		ProdutoDeleteResponse response = new ProdutoDeleteResponse();
		
		try {
			
			Produto produto = service.findById(idProduto);
			
			if(produto != null) {
				service.delete(produto);
				
				response.setMensagem("Produto excluído com sucesso!");
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
