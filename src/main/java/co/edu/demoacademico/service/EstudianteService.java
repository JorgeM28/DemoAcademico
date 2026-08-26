package co.edu.demoacademico.service;

import co.edu.demoacademico.model.Estudiante;
import co.edu.demoacademico.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
/**
 * Capa: LÓGICA DE NEGOCIO (Service)
 * Contiene las reglas del dominio (ej. email único) y coordina el acceso a datos.
 */
@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public Estudiante crear(Estudiante estudiante) {

        // ----------------------------
        // ZONA DE LÓGICA DE NEGOCIO:
        // Regla: email único
        // ----------------------------
        repository.findByEmail(estudiante.getEmail())
                .ifPresent(e -> {
                    throw new IllegalStateException("Email ya registrado");
                });

        // ============================
        // ZONA DE ACCESO A LA BD:
        // Persistencia vía Repository
        // ============================
        return repository.save(estudiante);
    }

    public Estudiante buscarPorEmail(String email) {
        // ============================
        // ZONA DE ACCESO A LA BD:
        // Consulta vía Repository
        // ============================
        return repository.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException(
                        "No existe un estudiante con el email: " + email));
    }

    public List<Estudiante> listar() {
        // ============================
        // ZONA DE ACCESO A LA BD:
        // Consulta vía Repository
        // ============================
        return repository.findAll();
    }
}