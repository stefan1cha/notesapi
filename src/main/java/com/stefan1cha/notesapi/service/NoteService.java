package com.stefan1cha.notesapi.service;

import com.stefan1cha.notesapi.entity.Note;

import java.util.List;

public interface NoteService {

    List<Note> getAllNotes();

    Note getNoteById(Long id);

    Note saveNote(Note note);

    void deleteNoteById(Long id);
}
