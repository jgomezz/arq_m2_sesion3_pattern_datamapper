package pe.edu.tecsup.mvc.app.mapper;

import org.springframework.stereotype.Component;
import pe.edu.tecsup.mvc.app.domain.Task;
import pe.edu.tecsup.mvc.app.entity.TaskEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    public TaskEntity toEntity(Task domain) {
        return null;
    }


    public Task toDomain(TaskEntity entity) {
        return Task.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .completada(entity.isCompletada())
                .build();
    }

    public List<Task> toDomainList(List<TaskEntity> entityTasks) {

//*
        return entityTasks.stream().map(this::toDomain).toList();
//*/
/*
        List<Task> tasks = new ArrayList<>();

        for(TaskEntity entity : entityTasks){
            Task task = this.toDomain(entity);
            tasks.add(task);
        }

        return tasks;
    }*/
    }
}
