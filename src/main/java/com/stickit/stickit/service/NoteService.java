package com.stickit.stickit.service;

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

    public Note create(String title, String content){
        Note note = new Note(title, content);
        return noteRepository.save(note);
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
