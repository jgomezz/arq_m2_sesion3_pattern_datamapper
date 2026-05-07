package pe.edu.tecsup.mvc.app.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.edu.tecsup.mvc.app.domain.Task;
import pe.edu.tecsup.mvc.app.persistence.entity.TaskEntity;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TaskMapper{

    TaskMapper INSTANCE = Mappers.getMapper( TaskMapper.class );

    Task toDomain(TaskEntity entity);

    TaskEntity toEntity(Task domain);

    List<Task> toDomainList(List<TaskEntity> entityTasks);

    List<TaskEntity> toEntityList(List<Task> domainTasks);
}

/*
@Component
public class TaskMapper {

    public TaskEntity toEntity(Task domain) {

        return TaskEntity.builder()
                .titulo(domain.getTitulo())
                .build();
    }


    public Task toDomain(TaskEntity entity) {
        return Task.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .completada(entity.isCompletada())
                .build();
    }

    public List<Task> toDomainList(List<TaskEntity> entityTasks) {

        return entityTasks.stream().map(this::toDomain).toList();

    }
}
*/