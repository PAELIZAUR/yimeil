package edu.unsada.yimeil.repository;

import edu.unsada.yimeil.models.Attachments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachmentsRepo extends CrudRepository<Attachments, Integer> {

    // Encontrar todos los adjuntos por correo (correoEmailId)
    List<Attachments> findByCorreoEmailId(int correoEmailId);

    // Encontrar un adjunto por su nombre de archivo
    List<Attachments> findByFilename(String filename);

    // Buscar adjuntos por URL
    List<Attachments> findByUrl(String url);

}

