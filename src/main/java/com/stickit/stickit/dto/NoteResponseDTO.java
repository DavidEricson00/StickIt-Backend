package com.stickit.stickit.dto;

import com.stickit.stickit.model.NoteColor;

import java.time.LocalDateTime;

public class NoteResponseDTO {
    private Long id;
    private NoteColor color;
    private String content;
    private LocalDateTime createdAt;

    public NoteResponseDTO(Long id, NoteColor color, String content, LocalDateTime createdAt) {
        this.id = id;
        this.color = color;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }
    
    public NoteColor getColor() {
        return color;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
