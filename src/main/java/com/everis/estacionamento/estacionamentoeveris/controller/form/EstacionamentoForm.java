package com.everis.estacionamento.estacionamentoeveris.controller.form;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import com.everis.estacionamento.estacionamentoeveris.modelo.Estacionamento;
import com.sun.istack.NotNull;


public class EstacionamentoForm {
	
	@NotNull @NotEmpty @Length(min=5, max=7)
	private String placa;
	@NotNull @NotEmpty @Length(max=10)
	private String marca;
	@NotNull @NotEmpty @Length(max=10)
	private String modelo;
	private double valor;
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Estacionamento converter() {

		return new Estacionamento(placa, marca, modelo, 0);
	}

}
