package com.stefan1cha.notesapi.controller;

import com.stefan1cha.notesapi.dto.NoteDto;
import com.stefan1cha.notesapi.entity.Note;
import com.stefan1cha.notesapi.mapper.NoteMapper;
import com.stefan1cha.notesapi.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController()
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(path = "notes")
    public ResponseEntity<List<NoteDto>> getAllNotes() {
        return new ResponseEntity<>(noteService.getAllNotes().stream().map(NoteMapper.INSTANCE::noteToNoteDto).toList(),
                OK);
    }

    @GetMapping(path = "notes/{id}")
    public ResponseEntity<NoteDto> getNoteById(@PathVariable Long id) {
        Note note = noteService.getNoteById(id);
        if (note == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(NoteMapper.INSTANCE.noteToNoteDto(note), OK);
    }

    @PostMapping(path = "notes")
    public ResponseEntity<NoteDto> createNote(@RequestBody NoteDto noteDto) {
        noteDto.setId(null);
        Note convertedNote = NoteMapper.INSTANCE.noteDtoToNote(noteDto);
        Note savedNote = noteService.saveNote(convertedNote);
        NoteDto savedNoteDto = NoteMapper.INSTANCE.noteToNoteDto(savedNote);
        return new ResponseEntity<>(savedNoteDto, HttpStatus.CREATED);
    }

    @PutMapping(path = "notes/{id}")
    public ResponseEntity<NoteDto> updateNote(@RequestBody NoteDto noteDto, @PathVariable Long id) {
        noteDto.setId(id);
        Note convertedNote = NoteMapper.INSTANCE.noteDtoToNote(noteDto);
        Note savedNote = noteService.saveNote(convertedNote);
        NoteDto updatedNoteDto = NoteMapper.INSTANCE.noteToNoteDto(savedNote);
        return new ResponseEntity<>(updatedNoteDto, OK);
    }

    @DeleteMapping(path = "notes/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        Note note = noteService.getNoteById(id);
        if (note == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        noteService.deleteNoteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
