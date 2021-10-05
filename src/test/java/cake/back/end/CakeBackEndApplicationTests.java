package cake.back.end;

import cake.back.end.controller.DolceController;
import cake.back.end.controller.IngredienteController;
import cake.back.end.dao.DolceRepository;

import static org.assertj.core.api.Assertions.assertThat;

import cake.back.end.dao.IngredienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CakeBackEndApplicationTests {

	@Autowired
	private DolceController dolceController;

	@Autowired
	private IngredienteController ingredienteController;

	@Autowired
	private DolceRepository dolceRepository;

	@Autowired
	private IngredienteRepository ingredienteRepository;

	@Test
	void contextLoads() {
		assertThat(dolceController).isNotNull();
		assertThat(dolceRepository).isNotNull();
	}

}
