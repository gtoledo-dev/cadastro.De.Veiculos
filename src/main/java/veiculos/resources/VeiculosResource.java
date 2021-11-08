package veiculos.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import veiculos.entities.Veiculos;
import veiculos.services.VeiculosService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculosResource {
	
	@Autowired
	private VeiculosService service;
	
	@GetMapping
	public ResponseEntity<List<Veiculos>> findAll(){
		List<Veiculos> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Veiculos> findById(@PathVariable Long id){
		Veiculos obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Veiculos> insert(@RequestBody Veiculos obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Veiculos> updateVeiculos(@PathVariable Long id, @RequestBody Veiculos obj){
		obj = service.updateVeiculos(id, obj);
		return ResponseEntity.ok().body(obj);
	}
		
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Veiculos> update(@PathVariable Long id, @RequestBody Veiculos obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
