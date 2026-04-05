package com.deadman.taskmapper.domain.task.dto;

import org.springframework.web.multipart.MultipartFile;

public record CreateTaskRequest(String name, Long parent, Long created_by, MultipartFile image) {
}
