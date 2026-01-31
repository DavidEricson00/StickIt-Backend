package com.stickit.stickit.service;

import com.stickit.stickit.dto.NoteCreateDTO;
import com.stickit.stickit.dto.NoteResponseDTO;
import com.stickit.stickit.dto.NoteUpdateDTO;
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
                note.getColor(),
                note.getContent(),
                note.getCreatedAt()
        );
    }

    public NoteResponseDTO create(NoteCreateDTO dto){
        Note note = new Note();
        note.setColor(dto.getColor());
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

    public NoteResponseDTO update(Long id, NoteUpdateDTO dto) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        if (dto.getColor() != null) {
            note.setColor(dto.getColor());
        }

        if (dto.getContent() != null && !dto.getContent().isBlank()) {
            note.setContent(dto.getContent());
        }

        return toResponseDTO(noteRepository.save(note));
    }
    
    public void delete(Long id){
        if (!noteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Note not found");
        }
        noteRepository.deleteById(id);
    }

}
