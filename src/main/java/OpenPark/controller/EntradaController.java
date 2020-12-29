package OpenPark.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OpenPark.dto.VeiculoDTO;
import OpenPark.model.CorVeiculo;
import OpenPark.model.Entrada;
import OpenPark.model.MarcaVeiculo;
import OpenPark.model.Veiculo;
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
    private ModelAndView entrada(VeiculoDTO veiculoDTO) {
    	ModelAndView mv = new ModelAndView("painel/entrada");
    	return mv;
    }
    
    @PostMapping
    private ModelAndView entradaRegistro(VeiculoDTO veiculoDTO) {
    	ModelAndView mv = new ModelAndView("painel/entrada");
    	Veiculo veiculo = veiculoDTO.toVeiculo();
    	Entrada entrada = new Entrada();
    	entrada.setVeiculo(veiculo);
    	entradaRepository.save(entrada);
    	return mv;
    }   
}
