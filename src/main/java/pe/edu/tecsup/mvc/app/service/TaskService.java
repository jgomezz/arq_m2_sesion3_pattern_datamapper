package pe.edu.tecsup.mvc.app.service;

import org.springframework.stereotype.Service;
import pe.edu.tecsup.mvc.app.entity.Task;
import pe.edu.tecsup.mvc.app.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> listar() {
        return repository.findAll();
    }

    public void crear(String titulo) {
        Task task = new Task(null, titulo);
        repository.save(task);
    }

    public void completar(Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        task.setCompletada(true);
        repository.save(task);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
