package OpenPark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OpenPark.model.CategoriaVeiculo;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaVeiculo, Long>{

}
