package com.dev.NexTask.infrastructure.gateway;

import com.dev.NexTask.core.entities.Task;
import com.dev.NexTask.core.gateway.TaskGateway;
import com.dev.NexTask.infrastructure.mapper.TaskEntityMapper;
import com.dev.NexTask.infrastructure.persistence.TaskEntity;
import com.dev.NexTask.infrastructure.persistence.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class TaskRepositoryGateway implements TaskGateway {

    private final TaskRepository taskRepository;
    private final TaskEntityMapper mapper;

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = mapper.toEntity(task);
        TaskEntity newTask = taskRepository.save(taskEntity);
        return mapper.toDomain(newTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAllByOrderByIdAsc()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Task> getTask(Long id) {
        Optional<TaskEntity> task = taskRepository.findById(id);
        return task.map(mapper::toDomain);
    }
}
