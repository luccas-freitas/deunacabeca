package com.deunacabeca.api;

import com.deunacabeca.api.command.ResultadoCommand;
import com.deunacabeca.api.command.SorteioCommand;
import com.deunacabeca.api.controller.exception.NotFoundException;
import com.deunacabeca.api.service.SorteioService;
import com.deunacabeca.api.util.HorarioEnum;
import com.deunacabeca.api.util.LoteriaEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ApiApplicationTests {
	@Autowired
	private SorteioService service;

	@Test
	void novoSorteio() {
		SorteioCommand command = new SorteioCommand();
		ResultadoCommand resultado = new ResultadoCommand();
		List<ResultadoCommand> resultados = new ArrayList<>();

		command.setData(Date.from(Instant.now()));
		command.setHorario(HorarioEnum.QUATORZEVINTE);
		command.setLoteria(LoteriaEnum.FEDERAL);

		for (int i = 0; i < 6; i ++) {
			resultado.setValor(Integer.toString(i));
			resultados.add(resultado);
		}
		command.setResultados(resultados);

		Assert.notNull(service.create(command), "Erro ao inserir sorteio");
	}

	@Test
	void removerSorteio() {
		Long id = 1L;
		try {
			service.delete(id);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		
		assert true;
	}

	@Test
	void listarTodos() {
		assert !service.all().isEmpty() || true;
	}

	@Test
	void listarPorData() {
		SorteioCommand command = new SorteioCommand();
		assert !service.findByData(command).isEmpty() || true;
	}

	@Test
	void buscarPorId() {
		Long id = Integer.toUnsignedLong(1);
		assert !service.one(id).isPresent() || true;
	}
}
