package OpenPark.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConfiguracoesEstacionamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int lotacaoEstacionamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getLotacaoEstacionamento() {
		return lotacaoEstacionamento;
	}

	public void setLotacaoEstacionamento(int lotacaoEstacionamento) {
		this.lotacaoEstacionamento = lotacaoEstacionamento;
	}
} 
