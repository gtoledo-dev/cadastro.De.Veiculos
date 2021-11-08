package veiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import veiculos.entities.Veiculos;

public interface VeiculosRepository extends JpaRepository<Veiculos, Long>{

}
