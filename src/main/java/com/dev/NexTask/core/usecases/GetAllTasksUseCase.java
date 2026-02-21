package com.dev.NexTask.core.usecases;

import com.dev.NexTask.core.entities.Task;

import java.util.List;

public interface GetAllTasksUseCase {

    public List<Task> execute();

}
