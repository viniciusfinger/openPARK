package OpenPark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OpenPark.model.MarcaVeiculo;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaVeiculo, Long> {

}
