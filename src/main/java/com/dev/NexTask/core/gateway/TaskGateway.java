package com.dev.NexTask.core.gateway;

import com.dev.NexTask.core.entities.Task;
import com.dev.NexTask.core.enums.TaskStatus;

import java.util.List;
import java.util.Optional;

public interface TaskGateway {

    Task save(Task task);
    void deleteTask(Long id);
    List<Task> getAllTasks();
    Optional<Task> getTask(Long id);

}
