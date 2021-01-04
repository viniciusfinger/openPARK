package OpenPark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OpenPark.service.PainelService;

@Controller
@RequestMapping("/painel")
public class PainelController {


	@Autowired
	PainelService painelService;
	
    @GetMapping
    public ModelAndView resumo() {
    	return painelService.resumo();
    }
    
    @GetMapping("/historico")
    public ModelAndView historico() {
    	return painelService.historico();
    }
}
