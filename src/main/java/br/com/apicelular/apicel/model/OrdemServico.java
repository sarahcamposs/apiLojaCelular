package br.com.apicelular.apicel.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.apicelular.apicel.model.enums.EstadoOS;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordemServico")
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "idOS")
	private Long idOS;
	
	@ManyToOne
	private Cliente cliente;
	
	@Column(name = "dataHora")
	private LocalDateTime dataHora;
	
	@Column(name = "modeloCelular")
	private String modeloCelular;
	
	@Column(name = "defeitoCelular")
	private String defeitoCelular;
	
	@Column(name = "valorOs")
	private BigDecimal valorOS;
	
	@Enumerated(EnumType.STRING)
	private EstadoOS estadoOS;
}
