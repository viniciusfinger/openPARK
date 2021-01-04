package OpenPark.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import OpenPark.repository.CategoriaRepository;
import OpenPark.utils.EstacionamentoUtils;

@Entity
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Veiculo veiculo;
    
    private Date horaEntrada;
    
    private Date horaSaida;
    
    private long tempoEstadia = 0;
    
    private Float preco = (float) 0;

    public Entrada() {
    	this.horaEntrada = new Date();
    }
    
	public void finaliza() {
		this.horaSaida = new Date();
		this.calculaTempoEstadia();
	}
	
	public void calculaTempoEstadia() {
		this.tempoEstadia = (horaSaida.getTime() - horaEntrada.getTime()) / (1000 * 60);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public long getTempoEstadia() {
		return tempoEstadia;
	}

	public void setTempoEstadia(long tempoEstadia) {
		this.tempoEstadia = tempoEstadia;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}
}
