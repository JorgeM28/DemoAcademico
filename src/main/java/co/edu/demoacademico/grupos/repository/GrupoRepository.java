package co.edu.demoacademico.repository;

import co.edu.demoacademico.grupos.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
}