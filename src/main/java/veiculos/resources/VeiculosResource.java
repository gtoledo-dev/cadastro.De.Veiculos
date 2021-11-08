package veiculos.resources;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import veiculos.entities.Veiculos;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculosResource {

	@GetMapping
	public ResponseEntity<Veiculos> findAll(){
		Veiculos vc = new Veiculos(1L, "Vectra", "Chevrolet", 2010, "gasolina", "Sim", Instant.parse("2010-07-07T10:03:53z"), Instant.parse("2011-07-07T09:00:53z"));
		return ResponseEntity.ok().body(vc);
	}
}
