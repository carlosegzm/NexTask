package com.dev.NexTask.infrastructure.beans;

import com.dev.NexTask.core.gateway.TaskGateway;
import com.dev.NexTask.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public ChangeStatusUseCase changeStatusUseCase(TaskGateway taskGateway){
        return new ChangeStatusUseCaseImpl(taskGateway);
    }

    @Bean
    public CreateTaskUseCase createTaskUseCase(TaskGateway taskGateway){
        return new CreateTaskUseCaseImpl(taskGateway);
    }

    @Bean
    public DeleteTaskUseCase deleteTaskUseCase(TaskGateway taskGateway){
        return new DeleteTaskUseCaseImpl(taskGateway);
    }

    @Bean
    public GetAllTasksUseCase getAllTasksUseCase(TaskGateway taskGateway){
        return new GetAllTasksUseCaseImpl(taskGateway);
    }

    @Bean
    public GetTaskUseCase getTaskUseCase(TaskGateway taskGateway){
        return new GetTaskUseCaseImpl(taskGateway);
    }

}
