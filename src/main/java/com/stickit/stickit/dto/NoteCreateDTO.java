package com.stickit.stickit.dto;

import jakarta.validation.constraints.NotBlank;

public class NoteCreateDTO {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Content is required")
    private String content;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
