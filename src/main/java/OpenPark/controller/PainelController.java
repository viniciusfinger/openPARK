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
    private ModelAndView resumo() {
    	
    	List<Entrada> entradas = entradaRepository.findByHoraSaidaIsNull();
    	
    	Integer quantidadeVeiculos = entradas.size();
    	Integer quantidadeVeiculosDisponivel = quantidadeVagasEstacionamento - quantidadeVeiculos; 
    	
    	ModelAndView mv = new ModelAndView("painel/resumo");
        mv.addObject("entradas", entradas);
        mv.addObject("quantidadeVeiculos", quantidadeVeiculos);
        mv.addObject("quantidadeVeiculosDisponivel", quantidadeVeiculosDisponivel);
        return mv;
    }
    
    @GetMapping("/historico")
    private ModelAndView historico() {
    	ModelAndView mv = new ModelAndView("painel/historico");
    	
    	List<Entrada> historicoEntradas = entradaRepository.findHistoricoUltimoDia();
    	mv.addObject("historicoEntradas", historicoEntradas);
    	mv.addObject("quantidadeVeiculosHoje", historicoEntradas.size());
    	
    	return mv;
    }
}
