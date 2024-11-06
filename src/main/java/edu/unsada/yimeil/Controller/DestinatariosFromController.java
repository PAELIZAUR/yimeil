package edu.unsada.yimeil.controller;

import edu.unsada.yimeil.models.DestinatariosFrom;
import edu.unsada.yimeil.repository.DestinatariosFromRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/destinatariosFrom")
public class DestinatariosFromController {

    @Autowired
    private DestinatariosFromRepo destinatariosFromRepository;

    // Obtener todos los destinatarios
    @GetMapping
    public List<DestinatariosFrom> getAllDestinatarios() {
        return destinatariosFromRepository.findAll();
    }

    // Obtener un destinatario por ID
    @GetMapping("/{id}")
    public DestinatariosFrom getDestinatarioById(@PathVariable("id") int id) {
        Optional<DestinatariosFrom> destinatario = destinatariosFromRepository.findById(id);
        return destinatario.orElse(null); // Devuelve null si no existe
    }

    // Crear un nuevo destinatario
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DestinatariosFrom createDestinatario(@RequestBody DestinatariosFrom destinatariosFrom) {
        return destinatariosFromRepository.save(destinatariosFrom);
    }

    // Actualizar un destinatario existente
    @PutMapping("/{id}")
    public DestinatariosFrom updateDestinatario(@PathVariable("id") int id, @RequestBody DestinatariosFrom destinatariosFrom) {
        if (destinatariosFromRepository.existsById(id)) {
            destinatariosFrom.setIdfrom(id);
            return destinatariosFromRepository.save(destinatariosFrom);
        } else {
            return null; // Si no se encuentra el destinatario
        }
    }

    // Eliminar un destinatario por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDestinatario(@PathVariable("id") int id) {
        destinatariosFromRepository.deleteById(id);
    }
}
