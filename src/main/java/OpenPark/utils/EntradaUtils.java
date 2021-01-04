package OpenPark.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import OpenPark.model.CategoriaVeiculo;
import OpenPark.model.Entrada;
import OpenPark.model.Veiculo;
import OpenPark.repository.CategoriaRepository;

public class EntradaUtils {	

	public static Float calculaPreco(Entrada entrada, List<CategoriaVeiculo> categorias) {
		Float preco = (float) 0;
		Veiculo veiculo = entrada.getVeiculo();
		long tempoEstadia = entrada.getTempoEstadia();
		
		String categoriaVeiculo = veiculo.getCategoria();
		
		for (CategoriaVeiculo categoria : categorias) {
			if (categoria.getCategoria().equals(categoriaVeiculo)) {
				Float valorMinutos = categoria.getValorHora() / 60;
				preco = valorMinutos * tempoEstadia;
				break;
			}
		}
		
		return preco;
	}
}
