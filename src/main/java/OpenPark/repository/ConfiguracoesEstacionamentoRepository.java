package OpenPark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OpenPark.model.ConfiguracoesEstacionamento;

@Repository
public interface ConfiguracoesEstacionamentoRepository extends JpaRepository<ConfiguracoesEstacionamento, Long> {}
