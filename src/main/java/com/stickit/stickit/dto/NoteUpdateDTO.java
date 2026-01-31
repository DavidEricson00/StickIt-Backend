package com.stickit.stickit.dto;

import com.stickit.stickit.model.NoteColor;

public class NoteUpdateDTO {

    private NoteColor color;
    private String content;

    public NoteColor getColor() {
        return color;
    }

    public String getContent() {
        return content;
    }
}
