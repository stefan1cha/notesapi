package com.stefan1cha.notesapi.service;

import com.stefan1cha.notesapi.entity.Note;
import com.stefan1cha.notesapi.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultNoteService implements NoteService {

    private final NoteRepository noteRepository;

    public DefaultNoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
}
