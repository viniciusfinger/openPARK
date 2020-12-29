package OpenPark.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import OpenPark.model.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {
	 List<Entrada> findByHoraSaidaIsNull();
	 
	 @Query(value = "SELECT * FROM entrada WHERE DATE(hora_entrada) BETWEEN CURRENT_DATE() - 1 AND CURRENT_DATE()", nativeQuery = true)
		List<Entrada> findHistoricoUltimoDia();
}
