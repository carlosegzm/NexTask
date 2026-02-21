package com.dev.NexTask.infrastructure.exception;

import com.dev.NexTask.core.exceptions.TaskNotFoundException;
import com.dev.NexTask.core.exceptions.TaskStateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandles {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<Map<String, String>> taskNotFoundException(TaskNotFoundException exc) {
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", exc.getMessage());
        response.put("Message: ", "Please, insert a valid Id for your task and try again.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TaskStateException.class)
    public ResponseEntity<Map<String, String>> taskStateException(TaskStateException exc) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Invalid State Transition");
        response.put("message", exc.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
