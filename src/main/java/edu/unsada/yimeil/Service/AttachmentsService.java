package edu.unsada.yimeil.service;

import edu.unsada.yimeil.models.Attachments;
import edu.unsada.yimeil.repository.AttachmentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentsService {

    private final AttachmentsRepo attachmentsRepo;

    // Constructor con la inyección del repositorio
    @Autowired
    public AttachmentsService(AttachmentsRepo attachmentsRepo) {
        this.attachmentsRepo = attachmentsRepo;
    }

    // Obtener todos los attachments
    public List<Attachments> getAllAttachments() {
        return (List<Attachments>) attachmentsRepo.findAll();
    }

    // Obtener un attachment por su ID
    public Optional<Attachments> getAttachmentById(int id) {
        return attachmentsRepo.findById(id);
    }

    // Guardar un attachment
    public Attachments saveAttachment(Attachments attachment) {
        return attachmentsRepo.save(attachment);
    }

    // Eliminar un attachment
    public void deleteAttachment(int id) {
        attachmentsRepo.deleteById(id);
    }

    // Encontrar attachments por nombre de archivo (filename)
    public List<Attachments> findAttachmentsByFilename(String filename) {
        return attachmentsRepo.findByFilename(filename);
    }

    // Encontrar attachments por URL
    public List<Attachments> findAttachmentsByUrl(String url) {
        return attachmentsRepo.findByUrl(url);
    }

    // Encontrar attachments por correoEmailId
    public List<Attachments> findAttachmentsByCorreoEmailId(int correoEmailId) {
        return attachmentsRepo.findByCorreoEmailId(correoEmailId);
    }
}
