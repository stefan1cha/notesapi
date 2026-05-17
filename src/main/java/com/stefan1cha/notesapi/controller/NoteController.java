package com.stefan1cha.notesapi.controller;

import com.stefan1cha.notesapi.entity.Note;
import com.stefan1cha.notesapi.service.NoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(path = "notes")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }
}
