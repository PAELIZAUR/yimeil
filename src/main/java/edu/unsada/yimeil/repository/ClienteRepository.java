package edu.unsada.yimeil.repository;

import edu.unsada.yimeil.model.Cliente;  // Importa la entidad
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Puedes agregar métodos personalizados aquí si los necesitas
}
