package com.stickit.stickit.controller;

import com.stickit.stickit.dto.NoteRequestDTO;
import com.stickit.stickit.dto.NoteResponseDTO;
import com.stickit.stickit.model.Note;
import com.stickit.stickit.service.NoteService;
import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<NoteResponseDTO> create(
            @RequestBody @Valid NoteRequestDTO dto
    ) {
        NoteResponseDTO response = noteService.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(noteService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<NoteResponseDTO>> getAllNotes() {
        return ResponseEntity.ok(noteService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteResponseDTO> updateNote(
            @PathVariable Long id,
            @RequestBody @Valid NoteRequestDTO dto
    ) {
        return ResponseEntity.ok(noteService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}