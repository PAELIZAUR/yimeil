package edu.unsada.yimeil.Controller;

import edu.unsada.yimeil.models.Attachments;
import edu.unsada.yimeil.service.AttachmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attachments")
public class AttachmentsController {

    private final AttachmentsService attachmentsService;

    // Inyectar el servicio AttachmentsService
    @Autowired
    public AttachmentsController(AttachmentsService attachmentsService) {
        this.attachmentsService = attachmentsService;
    }

    // Obtener todos los attachments
    @GetMapping("/getAll")
    public ResponseEntity<List<Attachments>> getAllAttachments() {
        List<Attachments> attachments = attachmentsService.getAllAttachments();
        return ResponseEntity.ok(attachments);
    }

    // Obtener un attachment por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Attachments> getAttachmentById(@PathVariable int id) {
        Optional<Attachments> attachment = attachmentsService.getAttachmentById(id);
        return attachment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Guardar un attachment
    @PostMapping("/save")
    public ResponseEntity<Attachments> saveAttachment(@RequestBody Attachments attachment) {
        Attachments savedAttachment = attachmentsService.saveAttachment(attachment);
        return ResponseEntity.ok(savedAttachment);
    }

    // Eliminar un attachment por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAttachment(@PathVariable int id) {
        attachmentsService.deleteAttachment(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar attachments por filename
    @GetMapping("/findByFilename/{filename}")
    public ResponseEntity<List<Attachments>> findAttachmentsByFilename(@PathVariable String filename) {
        List<Attachments> attachments = attachmentsService.findAttachmentsByFilename(filename);
        return ResponseEntity.ok(attachments);
    }

    // Buscar attachments por URL
    @GetMapping("/findByUrl/{url}")
    public ResponseEntity<List<Attachments>> findAttachmentsByUrl(@PathVariable String url) {
        List<Attachments> attachments = attachmentsService.findAttachmentsByUrl(url);
        return ResponseEntity.ok(attachments);
    }

    // Buscar attachments por correoEmailId
    @GetMapping("/findByCorreoEmailId/{correoEmailId}")
    public ResponseEntity<List<Attachments>> findAttachmentsByCorreoEmailId(@PathVariable int correoEmailId) {
        List<Attachments> attachments = attachmentsService.findAttachmentsByCorreoEmailId(correoEmailId);
        return ResponseEntity.ok(attachments);
    }
}
