package com.stefan1cha.notesapi.service;

import com.stefan1cha.notesapi.entity.Note;
import com.stefan1cha.notesapi.repository.NoteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultNoteServiceTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private DefaultNoteService noteService;

    @Test
    void getAllNotesReturnsNotesFromRepository() {
        List<Note> notes = List.of(
                Note.builder()
                        .id(1L)
                        .title("First note")
                        .content("Remember to write tests")
                        .archived(false)
                        .build(),
                Note.builder()
                        .id(2L)
                        .title("Second note")
                        .content("Mockito keeps this fast")
                        .archived(true)
                        .build()
        );
        when(noteRepository.findAll()).thenReturn(notes);

        List<Note> result = noteService.getAllNotes();

        assertThat(result).containsExactlyElementsOf(notes);
        verify(noteRepository).findAll();
    }
}
