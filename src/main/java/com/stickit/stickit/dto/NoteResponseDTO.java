package com.stickit.stickit.dto;

import java.time.LocalDateTime;

public class NoteResponseDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public NoteResponseDTO(Long id, String title, String content, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
