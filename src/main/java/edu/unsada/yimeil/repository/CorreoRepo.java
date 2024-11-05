package edu.unsada.yimeil.repository;

import edu.unsada.yimeil.models.Correo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CorreoRepo extends CrudRepository<Correo, Integer> {

    @Query("SELECT c FROM Correo c LEFT JOIN FETCH c.attachments WHERE c.emailId = :emailId")
    Optional<Correo> findCorreoWithAttachments(@Param("emailId") int emailId);
}
