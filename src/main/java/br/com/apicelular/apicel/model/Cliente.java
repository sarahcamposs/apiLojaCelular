package br.com.apicelular.apicel.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idCliente")
	private Long idCliente;
	
	@Column(name = "nomeCliente")
	private String nomeCliente;
	
	@Column (name = "telefoneCliente")
	private String telefoneCliente;
	
	@Column(name = "enderecoCliente")
	private String enderecoCliente;
	
//	@OneToMany
//	private List<OrdemServico> lstOSCliente;
	
	public Cliente() {
	}

	public Cliente(String nomeCliente, String telefoneCliente, String enderecoCliente, Long idCliente) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.telefoneCliente = telefoneCliente;
		this.enderecoCliente = enderecoCliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

//	public List<OrdemServico> getLstOSCliente() {
//		return lstOSCliente;
//	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(idCliente, other.idCliente);
	}

	
	
}
