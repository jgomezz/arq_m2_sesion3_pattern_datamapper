package pe.edu.tecsup.mvc.app.service;

import org.springframework.stereotype.Service;
import pe.edu.tecsup.mvc.app.entity.TaskEntity;
import pe.edu.tecsup.mvc.app.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskEntity> listar() {
        return repository.findAll();
    }

    public void crear(String titulo) {
        //TaskEntity task = new TaskEntity(null, titulo);
        TaskEntity task = TaskEntity.builder()
                                .titulo(titulo)
                                .build();
        repository.save(task);
    }

    public void completar(Long id) {
        TaskEntity task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        task.setCompletada(true);
        repository.save(task);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
