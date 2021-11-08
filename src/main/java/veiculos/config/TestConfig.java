package veiculos.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import veiculos.entities.Veiculos;
import veiculos.repositories.VeiculosRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private VeiculosRepository veiculosRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Veiculos v1 = new Veiculos(null, "Astra", "Chevrolet", 2005, "2 portas", "sim", Instant.parse("2010-07-07T10:03:53z"), Instant.parse("2011-07-07T09:00:53z"));
		Veiculos v2 = new Veiculos(null, "Vectra", "Chevrolet", 2010, "4 portas", "sim", Instant.parse("2010-07-07T10:03:53z"), Instant.parse("2011-07-07T09:00:53z"));
		
		veiculosRepository.saveAll(Arrays.asList(v1, v2));
	}


}
