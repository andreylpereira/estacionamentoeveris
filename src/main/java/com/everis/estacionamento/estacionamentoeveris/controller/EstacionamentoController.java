package com.everis.estacionamento.estacionamentoeveris.controller;

import java.net.URI;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.everis.estacionamento.estacionamentoeveris.controller.dto.EstacionamentoDto;
import com.everis.estacionamento.estacionamentoeveris.controller.form.AtualizarSaidaEstacionamentoForm;
import com.everis.estacionamento.estacionamentoeveris.controller.form.EstacionamentoForm;
import com.everis.estacionamento.estacionamentoeveris.modelo.Estacionamento;
import com.everis.estacionamento.estacionamentoeveris.repository.EstacionamentoRepository;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {

	@Autowired
	private EstacionamentoRepository estacionamentoRepository;

	@PostMapping @Transactional
	public ResponseEntity<EstacionamentoDto> cadastrar(@RequestBody @Valid EstacionamentoForm form,
			UriComponentsBuilder uriBuilder) {
		Estacionamento estacionamento = form.converter();
		estacionamentoRepository.save(estacionamento);

		URI uri = uriBuilder.path("/estacionamento/{id}").buildAndExpand(estacionamento.getId()).toUri();
		return ResponseEntity.created(uri).body(new EstacionamentoDto(estacionamento));
	}

	@GetMapping("/{id}")
	public EstacionamentoDto detalhar(@PathVariable Long id) {
		Estacionamento estacionamento = estacionamentoRepository.getOne(id);
		return new EstacionamentoDto(estacionamento);
	}

	@PutMapping("pagamento/{placa}")
	@Transactional
	public ResponseEntity<EstacionamentoDto> atualizarSaida(@PathVariable String placa,
			@RequestBody @Valid AtualizarSaidaEstacionamentoForm form) {

		Estacionamento estacionamento = form.atualizarPorId(placa, estacionamentoRepository);

		return ResponseEntity.ok(new EstacionamentoDto(estacionamento));

	}

}
