package OpenPark.utils;

import org.springframework.beans.factory.annotation.Autowired;

import OpenPark.repository.CorRepository;
import OpenPark.repository.MarcaRepository;

public class EntradaUtils {
	@Autowired
	CorRepository corRepository;
	
	@Autowired
	MarcaRepository marcaRepository;
	
}
