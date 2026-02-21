package com.dev.NexTask.infrastructure.presentation;

import com.dev.NexTask.core.entities.Task;
import com.dev.NexTask.core.enums.TaskStatus;
import com.dev.NexTask.core.usecases.*;
import com.dev.NexTask.infrastructure.dtos.TaskRequestDTO;
import com.dev.NexTask.infrastructure.dtos.TaskResponseDTO;
import com.dev.NexTask.infrastructure.mapper.TaskDtosMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/vi/task")
public class TaskController {

    private final TaskDtosMapper mapper;
    private final ChangeStatusUseCase changeStatusUseCase;
    private final CreateTaskUseCase createTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAllTasksUseCase getAllTasksUseCase;
    private final GetTaskUseCase getTaskUseCase;

    @PatchMapping("/changestatus/{id}/{status}")
    public ResponseEntity<Map<String, Object>> changeStatus(@PathVariable Long id, @PathVariable TaskStatus status) {
        Task newTask = changeStatusUseCase.execute(id, status);
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Task status updated successfully.");
        response.put("Task info: ", mapper.toResponse(newTask));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/create")
    public ResponseEntity<Map<String, Object>> createTask(@RequestBody TaskRequestDTO dto) {
        Task newTask = createTaskUseCase.execute(mapper.toDomain(dto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Task registered successfully.");
        response.put("Task info: ", mapper.toResponse(newTask));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        List<TaskResponseDTO> response = getAllTasksUseCase.execute()
                .stream()
                .map(mapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TaskResponseDTO> getTask(@PathVariable Long id) {
        Task task = getTaskUseCase.execute(id);
        TaskResponseDTO response = mapper.toResponse(task);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        deleteTaskUseCase.execute(id);
    }

}
