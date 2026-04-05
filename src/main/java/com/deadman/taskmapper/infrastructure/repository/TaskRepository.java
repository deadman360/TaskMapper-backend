package com.deadman.taskmapper.infrastructure.repository;

import com.deadman.taskmapper.domain.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
