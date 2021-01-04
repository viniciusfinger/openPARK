package OpenPark.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
import OpenPark.utils.EstacionamentoUtils;

@Service
public class EstacionamentoService {
	@Autowired
	CorRepository corRepository;
	
	@Autowired
	MarcaRepository marcaRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	EntradaRepository entradaRepository;
	
	public ModelAndView entradaForm() {
    	ModelAndView mv = new ModelAndView("painel/entrada");
    	
    	List<MarcaVeiculo> marcas = marcaRepository.findAll();
    	List<CorVeiculo> cores = corRepository.findAll();
    	List<CategoriaVeiculo> categorias = categoriaRepository.findAll();
    	
    	mv.addObject("cores", cores);
    	mv.addObject("marcas", marcas);
    	mv.addObject("categorias", categorias);
    	
    	return mv;
	}
	
	public ModelAndView entradaSave(VeiculoDTO veiculoDTO, ModelAndView mv) {
		Veiculo veiculo = veiculoDTO.toVeiculo();
    	Entrada entrada = new Entrada();
    	entrada.setVeiculo(veiculo);
    	entradaRepository.save(entrada);
    	
    	mv.setViewName("redirect:/painel");
    	return mv;
	}
	
	public String saida(Long idEntrada) {
		List<CategoriaVeiculo> categorias = categoriaRepository.findAll();
		
		Optional<Entrada> entradaOPT = entradaRepository.findById(idEntrada);
		Entrada entrada = entradaOPT.get();
		
		entrada.finaliza();
		
		Float preco = EstacionamentoUtils.calculaPreco(entrada, categorias);
		
		entrada.setPreco(preco);
		
		entradaRepository.save(entrada);
		
		return "redirect:/painel";
	}
}
