package OpenPark.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OpenPark.dto.VeiculoDTO;
import OpenPark.service.EstacionamentoService;


@Controller
@RequestMapping("/estacionamento")
public class EstacionamentoController {

	@Autowired
	EstacionamentoService estacionamentoService;
	
	 @GetMapping("/entrada")
	    public ModelAndView entradaForm(VeiculoDTO veiculoDTO) {
		 	return estacionamentoService.entradaForm();
	    }
	    
	    @PostMapping("/entrada")
	    public ModelAndView entradaSave(@Valid VeiculoDTO veiculoDTO, BindingResult result) {
	    	ModelAndView mv = new ModelAndView("painel/entrada");
	    	
	    	if (result.hasErrors()) {
	    		return estacionamentoService.entradaForm();
	    	}
	    	
	    	return estacionamentoService.entradaSave(veiculoDTO, mv);
	    }
	
	@GetMapping("/saida/{idEntrada}")
	public String saida(@PathVariable Long idEntrada) {
		return estacionamentoService.saida(idEntrada);
	}
}