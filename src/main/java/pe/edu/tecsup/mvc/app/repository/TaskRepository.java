package pe.edu.tecsup.mvc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.mvc.app.entity.Task;

//*
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
//*/

/*
@Repository
public class TaskRepository {
    // "Base de datos" en memoria
    private Map<Long, Task> tasks = new HashMap<>();
    private Long currentId = 1L;

    // Constructor: agregar datos de ejemplo
    public TaskRepository() {
        save(new Task(null, "Aprender Spring MVC"));
        save(new Task(null, "Crear proyecto de ejemplo"));
        save(new Task(null, "Estudiar Thymeleaf"));
    }
    // Obtener todas las tareas
    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    // Buscar por ID
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }

    // Guardar (crear o actualizar)
    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(currentId++);
        }
        tasks.put(task.getId(), task);
        return task;
    }

    // Eliminar por ID
    public void deleteById(Long id) {
        tasks.remove(id);
    }
}
//*/