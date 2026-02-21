package com.dev.NexTask.core.usecases;

import com.dev.NexTask.core.entities.Task;

public interface GetTaskUseCase {

    public Task execute(Long id);

}
