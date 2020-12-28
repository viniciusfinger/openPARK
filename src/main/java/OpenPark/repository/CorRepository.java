package OpenPark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OpenPark.model.CorVeiculo;

@Repository
public interface CorRepository extends JpaRepository<CorVeiculo, Long> {

}
