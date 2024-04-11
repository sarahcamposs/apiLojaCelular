package br.com.apicelular.apicel.testes;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.apicelular.apicel.model.Cliente;
import br.com.apicelular.apicel.repository.ClienteRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente("Sarah","85987991403", "Aldeota");
		Cliente c2 = new Cliente("Erick","85987990003", "Aldeota");
		
		clienteRepository.saveAll(Arrays.asList(c1, c2));
	}
	
	
}
