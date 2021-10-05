package cake.back.end.controller;

import cake.back.end.dao.DolceRepository;
import cake.back.end.entity.Dolce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class DolceController {

    public static final String IMG_DIR = System.getProperty("user.home") + File.separator + "tmp_img";

    @Autowired
    ServletContext context;

    @Autowired
    DolceRepository dolceRepository;

    @GetMapping("/dolci")
    public ResponseEntity<List<Dolce>> findAll(@RequestParam(required = false) String nome){
        try {
            List<Dolce> dolci = new ArrayList<>();

            if (nome == null)
                dolceRepository.findAll().forEach(dolci::add);
            else
                dolceRepository.findByName(nome).forEach(dolci::add);

            if (dolci.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(dolci, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/dolci/{id}")
    public ResponseEntity<Dolce> findById(@PathVariable Long id){
        Optional<Dolce> dolce = dolceRepository.findById(id);
        if (dolce.isPresent()) {
            return new ResponseEntity<>(dolce.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/members/dolci/create")
    public ResponseEntity<Dolce> create(@RequestBody Dolce dolce) throws IOException {
        try {
            if(dolce.getImgName() == null || dolce.getImgName().isEmpty()){
                dolce.setImageUrl(IMG_DIR);
                dolce.setImgName("placeholder.png");
            }else{
                dolce.setImageUrl(IMG_DIR + File.separator + dolce.getImgName());
            }
            Dolce _dolce = dolceRepository.save(dolce);
            return new ResponseEntity<>(_dolce, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/members/dolci/upload")
    public ResponseEntity<String> upload( @RequestParam("image") MultipartFile file) throws IOException {
        String message = "";
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Path fileDir = get(IMG_DIR, fileName).toAbsolutePath().normalize();
            copy(file.getInputStream(), fileDir, StandardCopyOption.REPLACE_EXISTING);
            message = "Uploaded the file successfully: " + fileName;
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            e.printStackTrace();
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @GetMapping("/dolci/download/{filename}")
    public ResponseEntity<Resource> download( @PathVariable("filename") String filename) throws IOException {
        Path filePath = get(IMG_DIR).toAbsolutePath().normalize().resolve(filename);
        if(!Files.exists(filePath)){
            throw  new FileNotFoundException(filename + "non found!");
        }
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders headers = new HttpHeaders();
        headers.add("File-name", filename);
        headers.add("CONTENT-DISPOSITION", "inline;File-Name=" + resource.getFilename());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(headers).body(resource);

    }

    @PutMapping("/members/dolci/update/{id}")
    public ResponseEntity<Dolce> update(@PathVariable("id") long id, @RequestBody Dolce dolce) {
        Optional<Dolce> opt = dolceRepository.findById(id);

        if (opt.isPresent()) {
            Dolce _dolce = opt.get();
            _dolce.setImgName(dolce.getImgName());
            _dolce.setCalorie(dolce.getCalorie());
            _dolce.setDescrizione(dolce.getDescrizione());
            _dolce.setDataCreazione(new Date());
            _dolce.setIngredienti(dolce.getIngredienti());
            _dolce.setPrezzo(dolce.getPrezzo());
            _dolce.setNome(dolce.getNome());
            _dolce.setScaduto(dolce.isScaduto());
            _dolce.setImageUrl(dolce.getImageUrl());
            _dolce.setUnitaDisponibili(dolce.getUnitaDisponibili());
            return new ResponseEntity<>(dolceRepository.save(_dolce), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/members/dolci/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id){
        try {
            dolceRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
