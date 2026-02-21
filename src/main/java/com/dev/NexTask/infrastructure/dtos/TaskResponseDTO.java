package com.dev.NexTask.infrastructure.dtos;

import com.dev.NexTask.core.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record TaskResponseDTO(Long id,
                              String title,
                              String description,
                              TaskStatus status,
                              @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                              LocalDateTime createdAt) {}
