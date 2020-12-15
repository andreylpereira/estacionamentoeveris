package com.everis.estacionamento.estacionamentoeveris.controller.form;

import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import com.everis.estacionamento.estacionamentoeveris.modelo.Estacionamento;
import com.everis.estacionamento.estacionamentoeveris.repository.EstacionamentoRepository;
import com.sun.istack.NotNull;

public class AtualizarSaidaEstacionamentoForm {

	
	@NotNull @NotEmpty 
	private LocalDateTime dataHoraSaida = LocalDateTime.now();
	
	public LocalDateTime getDataHoraSaida() {
		return dataHoraSaida;
	}

	public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}
	

	public Estacionamento atualizarPorId(String placa, EstacionamentoRepository estacionamentoRepository) {
		Estacionamento estacionamento = estacionamentoRepository.findOneByPlaca(placa);
		estacionamento.setDataHoraSaida(this.dataHoraSaida);

		return estacionamento;
	}

}
