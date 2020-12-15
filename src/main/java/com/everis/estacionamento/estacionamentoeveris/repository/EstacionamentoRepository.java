package com.everis.estacionamento.estacionamentoeveris.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.estacionamento.estacionamentoeveris.modelo.Estacionamento;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long> {

	Estacionamento findOneByPlaca(String placa);
	

}
