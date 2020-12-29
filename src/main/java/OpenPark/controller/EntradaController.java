package OpenPark.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
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
    	
    	List<MarcaVeiculo> marcas = marcaRepository.findAll();
    	List<CorVeiculo> cores = corRepository.findAll();
    	
    	mv.addObject("cores", cores);
    	mv.addObject("marcas", marcas);
    	
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
    
    @PostMapping
    private ModelAndView entradaRegistro(@Valid VeiculoDTO veiculoDTO, BindingResult result) {
    	ModelAndView mv = new ModelAndView("painel/entrada");
    	
    	if (result.hasErrors()) {
    		List<MarcaVeiculo> marcas = marcaRepository.findAll();
        	List<CorVeiculo> cores = corRepository.findAll();
        	
        	mv.addObject("cores", cores);
        	mv.addObject("marcas", marcas);
    		return mv;
    	}
    	
    	Veiculo veiculo = veiculoDTO.toVeiculo();
    	Entrada entrada = new Entrada();
    	entrada.setVeiculo(veiculo);
    	entradaRepository.save(entrada);
    	return mv;
    }   
}
