package veiculos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import veiculos.entities.Veiculos;
import veiculos.repositories.VeiculosRepository;
import veiculos.services.exceptions.ResourceNotFoundException;

@Service
public class VeiculosService {

	@Autowired
	private VeiculosRepository repository;

	public List<Veiculos> findAll() {
		return repository.findAll();
	}

	public Veiculos findById(Long id) {
		Optional<Veiculos> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Veiculos insert(Veiculos obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}

	public Veiculos updateVeiculos(Long id, Veiculos obj) {
		Veiculos entityVeiculos = repository.getOne(id);
		updateVeiculos(entityVeiculos, obj);
		return repository.save(entityVeiculos);
	}

	private void updateVeiculos(Veiculos entityVeiculos, Veiculos obj) {
		entityVeiculos.setVeiculo(obj.getVeiculo());
		entityVeiculos.setMarca(obj.getMarca());
		entityVeiculos.setAno(obj.getAno());
		entityVeiculos.setDescricao(obj.getDescricao());
		entityVeiculos.setVendido(obj.getVendido());
		entityVeiculos.setCreated(obj.getCreated());
		entityVeiculos.setUpdated(obj.getUpdated());

	}

	public Veiculos update(Long id, Veiculos obj) {
		Veiculos entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Veiculos entity, Veiculos obj) {
		entity.setDescricao(obj.getDescricao());
		entity.setVendido(obj.getVendido());
		entity.setUpdated(obj.getUpdated());

	}

}
