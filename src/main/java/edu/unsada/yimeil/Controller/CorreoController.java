package edu.unsada.yimeil.Controller;

import edu.unsada.yimeil.models.Correo;
import edu.unsada.yimeil.repository.CorreoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/correo")
public class CorreoController {

    private final CorreoRepo correoRepo;

    @Autowired
    public CorreoController(CorreoRepo correoRepo) {
        this.correoRepo = correoRepo;
    }

    // Mostrar un mensaje simple
    @GetMapping("/mostrardatos")
    public ResponseEntity<String> mostrardatos() {
        return ResponseEntity.ok("Hola mundo");
    }

    // Obtener todos los correos
    @GetMapping("/getAllCorreo")
    public ResponseEntity<List<Correo>> getAllCorreo() {
        List<Correo> correos = correoRepo.findAll();
        return ResponseEntity.ok(correos);
    }

    // Crear un nuevo correo
    @PostMapping("/create")
    public ResponseEntity<Correo> createCorreo(@RequestBody Correo correo) {
        Correo newCorreo = correoRepo.save(correo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCorreo);
    }

    // Obtener un correo por ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Correo> getCorreoById(@PathVariable Integer id) {
        Optional<Correo> correo = correoRepo.findById(id);
        return correo.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Actualizar un correo existente
    @PutMapping("/update/{id}")
    public ResponseEntity<Correo> updateCorreo(@PathVariable Integer id, @RequestBody Correo correoDetails) {
        return correoRepo.findById(id).map(correo -> {
            correo.setSubject(correoDetails.getSubject());
            correo.setBody(correoDetails.getBody());
            // Agregar aquí otros campos según los atributos de Correo
            Correo updatedCorreo = correoRepo.save(correo);
            return ResponseEntity.ok(updatedCorreo);
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Eliminar un correo
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCorreo(@PathVariable Integer id) {
        return correoRepo.findById(id).map(correo -> {
            correoRepo.delete(correo);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
