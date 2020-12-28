package OpenPark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OpenPark.model.Entrada;

import OpenPark.repository.EntradaRepository;

@Controller
@RequestMapping("/painel")
public class PainelController {

	@Autowired
	public EntradaRepository entradaRepository;
	public Integer quantidadeVagasEstacionamento = 30;
	
	
    @GetMapping
    private ModelAndView principal() {
    	
    	List<Entrada> entradas = entradaRepository.findByHoraSaidaIsNull();
    	
    	Integer quantidadeVeiculos = entradas.size();
    	Integer quantidadeVeiculosDisponivel = quantidadeVagasEstacionamento - quantidadeVeiculos; 
    	
    	ModelAndView mv = new ModelAndView("painel/principal");
        mv.addObject("entradas", entradas);
        mv.addObject("quantidadeVeiculos", quantidadeVeiculos);
        mv.addObject("quantidadeVeiculosDisponivel", quantidadeVeiculosDisponivel);
        return mv;
    }
}
