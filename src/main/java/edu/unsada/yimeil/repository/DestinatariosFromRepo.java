package edu.unsada.yimeil.repository;

import edu.unsada.yimeil.models.DestinatariosFrom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinatariosFromRepo extends JpaRepository<DestinatariosFrom, Integer> {
    // Puedes añadir métodos personalizados si lo necesitas
}
