package cake.back.end.dao;

import cake.back.end.entity.Dolce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface DolceRepository extends JpaRepository<Dolce, Long> {

    @Query("SELECT dolce FROM Dolce dolce WHERE dolce.nome LIKE CONCAT('%', :nome ,'%')")
    List<Dolce> findByName(@RequestParam("nome") String nome );

}
