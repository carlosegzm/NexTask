package com.dev.NexTask.core.usecases;

import com.dev.NexTask.core.entities.Task;
import com.dev.NexTask.core.enums.TaskStatus;

public interface ChangeStatusUseCase {

    public Task execute(Long id, TaskStatus status);

}
