package com.stickit.stickit.dto;

import com.stickit.stickit.model.NoteColor;
import jakarta.validation.constraints.NotBlank;

public class NoteCreateDTO {
    @NotBlank(message = "Color is required")
    private NoteColor color;

    private String content;

    public NoteColor getColor() {
        return color;
    }

    public String getContent() {
        return content;
    }
}
