package OpenPark.dto;

import javax.validation.constraints.NotBlank;

import OpenPark.model.Veiculo;

public class VeiculoDTO {
	
	@NotBlank
	public String modelo;
	
	@NotBlank
	public String marca;
	
	@NotBlank
	public String cor;
	
	@NotBlank
	public String placa;
	
	public Veiculo toVeiculo() {
		Veiculo veiculo = new Veiculo();
		veiculo.setCor(cor);
		veiculo.setModelo(modelo);
		veiculo.setMarca(marca);
		veiculo.setPlaca(placa);
		
		return veiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
 }
