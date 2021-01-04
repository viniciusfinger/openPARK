package OpenPark.controller;

import java.util.List;
import java.util.Optional;

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
import OpenPark.model.CategoriaVeiculo;
import OpenPark.model.CorVeiculo;
import OpenPark.model.Entrada;
import OpenPark.model.MarcaVeiculo;
import OpenPark.model.Veiculo;
import OpenPark.repository.CategoriaRepository;
import OpenPark.repository.CorRepository;
import OpenPark.repository.EntradaRepository;
import OpenPark.repository.MarcaRepository;
import OpenPark.utils.EntradaUtils;


@Controller
@RequestMapping("/estacionamento")
public class EstacionamentoController {

	@Autowired
	EntradaRepository entradaRepository;
	
	@Autowired
	CorRepository corRepository;
	
	@Autowired
	MarcaRepository marcaRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	@GetMapping("/saida/{idEntrada}")
	public String saida(@PathVariable Long idEntrada) {
		EntradaUtils entradaUtils = new EntradaUtils();
		
		List<CategoriaVeiculo> categorias = categoriaRepository.findAll();
		
		Optional<Entrada> entradaOPT = entradaRepository.findById(idEntrada);
		Entrada entrada = entradaOPT.get();
		
		entrada.finaliza();
		
		Float preco = EntradaUtils.calculaPreco(entrada, categorias);
		
		entrada.setPreco(preco);
		
		entradaRepository.save(entrada);
		
		return "redirect:/painel";
	}
	
    @GetMapping("/entrada")
    private ModelAndView entrada(VeiculoDTO veiculoDTO) {
    	ModelAndView mv = new ModelAndView("painel/entrada");
    	
    	List<MarcaVeiculo> marcas = marcaRepository.findAll();
    	List<CorVeiculo> cores = corRepository.findAll();
    	List<CategoriaVeiculo> categorias = categoriaRepository.findAll();
    	
    	mv.addObject("cores", cores);
    	mv.addObject("marcas", marcas);
    	mv.addObject("categorias", categorias);
    	
    	return mv;
    }
    
    @PostMapping("/entrada")
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
    	
    	mv.setViewName("redirect:/painel");
    	return mv;
    }       
}
