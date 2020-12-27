package OpenPark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OpenPark.model.CorVeiculo;
import OpenPark.model.Entrada;
import OpenPark.model.MarcaVeiculo;
import OpenPark.model.Veiculo;
import OpenPark.repository.EntradaRepository;

@Controller
@RequestMapping("/painel")
public class PainelController {

	@Autowired
	public EntradaRepository entradaRepository;
	
    @GetMapping
    private ModelAndView principal() {
    	
    	List<Entrada> entradas = entradaRepository.findAll();
    	
    	ModelAndView mv = new ModelAndView("painel/principal");
        mv.addObject("entradas", entradas);
        return mv;
    }
}
