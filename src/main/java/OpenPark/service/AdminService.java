package OpenPark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import OpenPark.model.ConfiguracoesEstacionamento;
import OpenPark.repository.ConfiguracoesEstacionamentoRepository;

@Service
public class AdminService {
	
	@Autowired
	ConfiguracoesEstacionamentoRepository configuracoesRepository;
	
	@Autowired
	
	public ModelAndView configuration() {
		ModelAndView mv = new ModelAndView("admin/configuration");
		ConfiguracoesEstacionamento configuracoes =  configuracoesRepository.findById(1l).orElse(null);
		mv.addObject("configuracoes", configuracoes);
		return mv;
	}
}
