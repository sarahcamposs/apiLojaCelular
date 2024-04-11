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

	public Cliente buscarPeloId(Long id) throws Throwable{
		Optional<Cliente> clienteNoRepositorio = clienteRepository.findById(id);

		if (clienteNoRepositorio == null) {
			throw new Exception("O id não existe no banco!");
		} else {
			return clienteRepository.getById(id);
		}
	}
	
	public void verificarExistencia(Cliente cliente) throws Throwable {
		buscarPeloId(cliente.getIdCliente());
	}
	
	public void salvar(Cliente cliente) throws Throwable {
		verificarExistencia(cliente);
		clienteRepository.save(cliente);
	}
	
	public void deletar(Long id) {
		clienteRepository.delete(clienteRepository.getById(id));
		}
	}
