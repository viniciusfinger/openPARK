package OpenPark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import OpenPark.model.Entrada;
import OpenPark.repository.EntradaRepository;

@Service
public class PainelService {
	
	@Autowired
	public EntradaRepository entradaRepository;
	
	public Integer quantidadeVagasEstacionamento = 30;
	
	public ModelAndView resumo() {
		List<Entrada> entradas = entradaRepository.findByHoraSaidaIsNull();
    	
    	Integer quantidadeVeiculos = entradas.size();
    	Integer quantidadeVeiculosDisponivel = quantidadeVagasEstacionamento - quantidadeVeiculos; 
    	
    	ModelAndView mv = new ModelAndView("painel/resumo");
        mv.addObject("entradas", entradas);
        mv.addObject("quantidadeVeiculos", quantidadeVeiculos);
        mv.addObject("quantidadeVeiculosDisponivel", quantidadeVeiculosDisponivel);
        return mv;
	}
	
	public ModelAndView historico() {
		ModelAndView mv = new ModelAndView("painel/historico");
    	
    	List<Entrada> historicoEntradas = entradaRepository.findHistoricoUltimoDia();
    	mv.addObject("historicoEntradas", historicoEntradas);
    	mv.addObject("quantidadeVeiculosHoje", historicoEntradas.size());
    	
    	return mv;
	}
}
