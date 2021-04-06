package br.com.cotiinformatica.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.interfaces.IProdutoRepository;

@Service
@Transactional
public class ProdutoService {
	
	@Autowired
	private IProdutoRepository repository;
	
	public void createOrUpdate(Produto produto) throws Exception{
		repository.save(produto);
	}
	
	public void delete(Produto produto) throws Exception{
		repository.delete(produto);
	}
	
	public List<Produto> findAll() throws Exception{
		return (List<Produto>) repository.findAll();
	}
	
	public Produto findById(Integer id) throws Exception{
		return repository.findById(id).get();
	}
}
