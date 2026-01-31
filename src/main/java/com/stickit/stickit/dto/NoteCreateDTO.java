package com.stickit.stickit.dto;

import com.stickit.stickit.model.NoteColor;
import jakarta.validation.constraints.NotNull;

public class NoteCreateDTO {
    @NotNull(message = "Color is required")
    private NoteColor color;

    private String content;

    public NoteColor getColor() {
        return color;
    }

    public String getContent() {
        return content;
    }
}
