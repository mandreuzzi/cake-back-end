package cake.back.end.controller;

import cake.back.end.dao.IngredienteRepository;
import cake.back.end.entity.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class IngredienteController {

    @Autowired
    IngredienteRepository ingredienteRepository;

    @GetMapping("/ingredienti")
    public ResponseEntity<List<Ingrediente>> findAll(@RequestParam(required = false) String nome){
        try {
            List<Ingrediente> ingredienti = new ArrayList<>();
            ingredienteRepository.findAll().forEach(ingredienti::add);

            if (ingredienti.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ingredienti, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
