package OpenPark.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OpenPark.model.CorVeiculo;
import OpenPark.model.Entrada;
import OpenPark.model.MarcaVeiculo;
import OpenPark.repository.CorRepository;
import OpenPark.repository.EntradaRepository;
import OpenPark.repository.MarcaRepository;


@Controller
@RequestMapping("/entrada")
public class EntradaController {

	@Autowired
	EntradaRepository entradaRepository;
	
	@Autowired
	CorRepository corRepository;
	
	@Autowired
	MarcaRepository marcaRepository;
	
	@GetMapping("/fecha/{idEntrada}")
	public String saida(@PathVariable Long idEntrada) {
		Optional<Entrada> entradaOPT = entradaRepository.findById(idEntrada);
		Entrada entrada = entradaOPT.get();
		entrada.finaliza();
		entradaRepository.save(entrada);
		return "forward:/painel";
	}
	
    @GetMapping
    private ModelAndView entrada() {
    	ModelAndView mv = new ModelAndView("painel/entrada");
    	
    	List<MarcaVeiculo> marcas = marcaRepository.findAll();
    	mv.addObject("marcas", marcas);
    	
    	List<CorVeiculo> cores = corRepository.findAll();
    	mv.addObject("cores", cores);
    	
    	return mv;
    }
}
