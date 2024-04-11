package br.com.apicelular.apicel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apicelular.apicel.model.Cliente;
import br.com.apicelular.apicel.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	public Cliente buscarPeloId(Long id){
		return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado" + id));	
	}
	
	public void verificarExistencia(Cliente cliente) throws Throwable {
		buscarPeloId(cliente.getIdCliente());
	}
	
	public Cliente salvar(Cliente cliente) {
		//verificarExistencia(cliente);
		return clienteRepository.save(cliente);
	}
	
	public void deletar(Long id) {
		Cliente clienteBase = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado" + id));
		clienteRepository.delete(clienteBase);
		}
	}
