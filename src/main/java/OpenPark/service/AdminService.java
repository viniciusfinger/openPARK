package OpenPark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import OpenPark.model.CategoriaVeiculo;
import OpenPark.model.ConfiguracoesEstacionamento;
import OpenPark.repository.CategoriaRepository;
import OpenPark.repository.ConfiguracoesEstacionamentoRepository;

@Service
public class AdminService {
	
	@Autowired
	ConfiguracoesEstacionamentoRepository configuracoesRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public ModelAndView configuration() {
		ModelAndView mv = new ModelAndView("admin/configuration");

		ConfiguracoesEstacionamento configuracoes =  configuracoesRepository.findById(1l).orElse(null);
		List<CategoriaVeiculo> categorias = categoriaRepository.findAll();
		
		mv.addObject("configuracoes", configuracoes);
		mv.addObject("categorias", categorias);
		return mv;
	}
}
