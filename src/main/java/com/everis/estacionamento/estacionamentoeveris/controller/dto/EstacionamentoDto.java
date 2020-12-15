package com.everis.estacionamento.estacionamentoeveris.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Transient;
import org.springframework.lang.Nullable;
import com.everis.estacionamento.estacionamentoeveris.modelo.Estacionamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class EstacionamentoDto {

	private Long id;
	private String placa;
	private String marca;
	private String modelo;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime dataHoraEntrada = LocalDateTime.now();
	@Nullable
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime dataHoraSaida;
	
	private double valor;
	@Transient
	private String mensagem = "Uma hora é 5 reais, cada hora adicional custa 2 reais.";

	public EstacionamentoDto(Estacionamento estacionamento) {
		this.id = estacionamento.getId();
		this.placa = estacionamento.getPlaca();
		this.marca = estacionamento.getMarca();
		this.modelo = estacionamento.getModelo();
		this.dataHoraEntrada = estacionamento.getDataHoraEntrada();
		this.dataHoraSaida = estacionamento.getDataHoraSaida();
		this.valor = estacionamento.getValor();
	}

	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public LocalDateTime getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public LocalDateTime getDataHoraSaida() {
		return dataHoraSaida;
	}

	public double getValor() {
		return valor;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public static List<EstacionamentoDto> converter(List<Estacionamento> estacionamento) {

		return estacionamento.stream().map(EstacionamentoDto::new).collect(Collectors.toList());
	}

	
}
