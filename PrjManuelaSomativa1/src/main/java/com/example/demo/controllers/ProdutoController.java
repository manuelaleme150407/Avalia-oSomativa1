package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Produto;
import com.example.demo.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoService produtoservice;

	@Autowired
	public ProdutoController(ProdutoService produtoservice) {
		this.produtoservice = produtoservice;
	}

	@PostMapping
	public Produto createProduto(@RequestBody Produto produto) {
		return produtoservice.saveProduto(produto);
	}

	// traz todos os registros
	@GetMapping
	public List<Produto> getAllProduto() {
		return produtoservice.getAll();
	}

	// traz somente o objeto específico pelo id
	@GetMapping("/{id}")
	public Produto getProduto(@PathVariable Long id) {
		return produtoservice.getProdutoById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		produtoservice.deleteProduto(id);
	}
	
}
