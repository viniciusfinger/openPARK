package OpenPark.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import OpenPark.model.Entrada;
import OpenPark.repository.EntradaRepository;


@Controller
@RequestMapping("/entrada")
public class EntradaController {

	@Autowired
	EntradaRepository entradaRepository;
	
	@GetMapping("/fecha/{idEntrada}")
	public String saida(@PathVariable Long idEntrada) {
		Optional<Entrada> entradaOPT = entradaRepository.findById(idEntrada);
		Entrada entrada = entradaOPT.get();
		entrada.finaliza();
		entradaRepository.save(entrada);
		return "forward:/painel";
	}
}
