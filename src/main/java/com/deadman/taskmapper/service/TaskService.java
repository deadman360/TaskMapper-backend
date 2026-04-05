package com.deadman.taskmapper.service;

import com.deadman.taskmapper.domain.task.Task;
import com.deadman.taskmapper.domain.task.dto.CreateTaskRequest;
import com.deadman.taskmapper.domain.task.dto.CreateTaskResponse;
import com.deadman.taskmapper.infrastructure.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public CreateTaskResponse create(CreateTaskRequest request) {
        Task entity = new Task();
        taskRepository.save(entity);
        return new CreateTaskResponse(entity.getId());
    }
}
