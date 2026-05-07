package pe.edu.tecsup.mvc.app.persistence;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.mvc.app.domain.Task;
import pe.edu.tecsup.mvc.app.persistence.entity.TaskEntity;
import pe.edu.tecsup.mvc.app.persistence.jpa.TaskJpaRepository;
import pe.edu.tecsup.mvc.app.persistence.mapper.TaskMapper;
import pe.edu.tecsup.mvc.app.repository.TaskRepository;

import java.util.List;

@AllArgsConstructor
@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final TaskJpaRepository jpaRepository;
    private final TaskMapper mapper;


    @Override
    public List<Task> findAll() {

        List<TaskEntity> entityTasks
                = this.jpaRepository.findAll();
        return this.mapper.toDomainList(entityTasks);
    }

    @Override
    public void save(Task task) {

        TaskEntity taskEntity = this.mapper.toEntity(task);
        this.jpaRepository.save(taskEntity);
    }

    @Override
    public Task findById(Long id) {

        TaskEntity task = this.jpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

        return this.mapper.toDomain(task);
    }

    @Override
    public void deleteById(Long id) {

        this.jpaRepository.deleteById(id);

    }
}
