package com.stickit.stickit.service;

import com.stickit.stickit.dto.NoteRequestDTO;
import com.stickit.stickit.dto.NoteResponseDTO;
import com.stickit.stickit.exception.ResourceNotFoundException;
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

    public List<NoteResponseDTO> findAll(){
        return noteRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public NoteResponseDTO update(Long id, NoteRequestDTO dto){
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());

        return toResponseDTO(noteRepository.save(note));
    }

    public void delete(Long id){
        noteRepository.deleteById(id);
    }
}
