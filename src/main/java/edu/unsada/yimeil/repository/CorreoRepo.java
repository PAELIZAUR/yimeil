package edu.unsada.yimeil.repository;

import edu.unsada.yimeil.models.Correo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorreoRepo extends JpaRepository<Correo, Integer> {
    // ...
}