package OpenPark.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MarcaVeiculo marca;

    @Enumerated(EnumType.STRING)
    private CorVeiculo cor;
    
    private String modelo;

    private String placa;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MarcaVeiculo getMarca() {
		return marca;
	}

	public void setMarca(MarcaVeiculo marca) {
		this.marca = marca;
	}

	public CorVeiculo getCor() {
		return cor;
	}

	public void setCor(CorVeiculo cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo.toUpperCase();
	}  
}