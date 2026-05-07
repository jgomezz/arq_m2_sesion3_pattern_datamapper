package pe.edu.tecsup.mvc.app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.mvc.app.domain.Task;
import pe.edu.tecsup.mvc.app.entity.TaskEntity;
import pe.edu.tecsup.mvc.app.mapper.TaskMapper;
import pe.edu.tecsup.mvc.app.repository.TaskRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskMapper mapper;

    public List<Task> listar() {

        List<TaskEntity> entityTasks = repository.findAll();
        // TO DO
        return this.mapper.toDomainList(entityTasks);
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
