package co.edu.demoacademico.repository;

import co.edu.demoacademico.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * Capa: ACCESO A DATOS (Repository)
 * Zona de acceso a la base de datos H2 vía Spring Data JPA.
 */
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    // ============================
    // ZONA DE ACCESO A LA BD (JPA)
    // ============================
    Optional<Estudiante> findByEmail(String email);
}