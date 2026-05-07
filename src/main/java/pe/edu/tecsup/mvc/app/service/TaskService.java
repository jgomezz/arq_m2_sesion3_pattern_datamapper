package pe.edu.tecsup.mvc.app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.mvc.app.domain.Task;
import pe.edu.tecsup.mvc.app.persistence.mapper.TaskMapper;
import pe.edu.tecsup.mvc.app.repository.TaskRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    private final TaskRepository repository;

    public List<Task> listar() {

        List<Task> tasks = repository.findAll();
        // TO DO
        //return this.mapper.toDomainList(entityTasks);
        return tasks;
    }

    public void crear(String titulo) {

        Task task = Task.builder()
                .titulo(titulo)
                .build();

        // TO DO



        //TaskEntity taskEntity = this.mapper.toEntity(task);

        //repository.save(taskEntity);
        repository.save(task);
    }

    public void completar(Long id) {
        Task task = repository.findById(id);
        task.setCompletada(true);
        repository.save(task);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
