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

import com.example.demo.entities.Cliente;
import com.example.demo.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteService clienteservice;

	@Autowired
	public ClienteController(ClienteService clienteservice) {
		this.clienteservice = clienteservice;
	}

	@PostMapping
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteservice.saveCliente(cliente);
	}

	// traz todos os registros
	@GetMapping
	public List<Cliente> getAllCliente() {
		return clienteservice.getAllCliente();
	}

	// traz somente o objeto específico pelo id
	@GetMapping("/{id}")
	public Cliente getCliente(@PathVariable Long id) {
		return clienteservice.getClienteById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Long id) {
		clienteservice.deleteCliente(id);
	}
	
}
