package pe.edu.tecsup.mvc.app.repository;

import pe.edu.tecsup.mvc.app.domain.Task;

import java.util.List;

public interface TaskRepository {

    List<Task> findAll();

    void save(Task task);

    Task  findById(Long id);

    void deleteById(Long id);
}
