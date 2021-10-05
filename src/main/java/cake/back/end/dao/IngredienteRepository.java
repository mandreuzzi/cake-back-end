package cake.back.end.dao;

import cake.back.end.entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

}
