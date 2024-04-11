package br.com.apicelular.apicel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.apicelular.apicel.model.Cliente;
import br.com.apicelular.apicel.repository.ClienteRepository;
import br.com.apicelular.apicel.services.ClienteService;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar(){
		List<Cliente> lista = clienteService.listar();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) throws Throwable {
		Cliente obj = clienteService.buscarPeloId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> inserirCliente(@RequestBody Cliente clienteNovo){
		Cliente clienteAtualizado = clienteService.salvar(clienteNovo);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteAtualizado);
	}
	
}
