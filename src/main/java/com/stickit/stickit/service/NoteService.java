package com.stickit.stickit.service;

import com.stickit.stickit.dto.NoteRequestDTO;
import com.stickit.stickit.dto.NoteResponseDTO;
import com.stickit.stickit.model.Note;
import com.stickit.stickit.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    private NoteResponseDTO toResponseDTO(Note note) {
        return new NoteResponseDTO(
                note.getId(),
                note.getTitle(),
                note.getContent(),
                note.getCreatedAt()
        );
    }

    public NoteResponseDTO create(NoteRequestDTO dto){
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());

        Note saved = noteRepository.save(note);
        return toResponseDTO(saved);
    }

    public List<Note> findAll(){
        return  noteRepository.findAll();
    }

    public Note update(Long id, String title, String content){
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        note.setTitle(title);
        note.setContent(content);

        return noteRepository.save(note);
    }

    public void delete(Long id){
        noteRepository.deleteById(id);
    }
}
