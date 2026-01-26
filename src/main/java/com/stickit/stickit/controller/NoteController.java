package com.stickit.stickit.controller;

import com.stickit.stickit.dto.NoteRequestDTO;
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
    public ResponseEntity<Note> create(
            @RequestBody @Valid NoteRequestDTO dto
    ) {
        Note note = noteService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(note);
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.findAll();
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note) {
        return noteService.update(id, note.getTitle(), note.getContent());
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.delete(id);
    }
}
