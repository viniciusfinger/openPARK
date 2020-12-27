package OpenPark.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OpenPark.model.CorVeiculo;
import OpenPark.model.MarcaVeiculo;
import OpenPark.model.Veiculo;

@Controller
@RequestMapping("/painel")
public class PainelController {

    @GetMapping
    private ModelAndView principal() {
    	
    	Veiculo veiculo = new Veiculo();
    	veiculo.setCor(CorVeiculo.BRANCO);
    	veiculo.setMarca(MarcaVeiculo.CHEVROLET);
    	veiculo.setModelo("Corsa");
    	Veiculo veiculo2 = new Veiculo();
    	veiculo2.setCor(CorVeiculo.VERMELHO);
    	veiculo2.setMarca(MarcaVeiculo.FIAT);
    	veiculo2.setModelo("Uno");
    	
    	ModelAndView mv = new ModelAndView("painel/principal");
        mv.addObject("veiculos", Arrays.asList(veiculo, veiculo2));
        return mv;
    }
}
