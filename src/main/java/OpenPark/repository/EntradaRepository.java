package OpenPark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OpenPark.model.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {

}
