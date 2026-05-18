package com.stefan1cha.notesapi.controller;

import com.stefan1cha.notesapi.entity.Note;
import com.stefan1cha.notesapi.repository.NoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NoteRepository noteRepository;

    @BeforeEach
    void setUp() {
        noteRepository.deleteAll();
    }

    @Test
    void getAllNotesReturnsNotesFromDatabase() throws Exception {
        noteRepository.saveAll(List.of(
                Note.builder()
                        .title("Shopping List")
                        .content("Milk, Eggs, Bread")
                        .archived(false)
                        .build(),
                Note.builder()
                        .title("Archived Note")
                        .content("This note is archived.")
                        .archived(true)
                        .build()
        ));

        mockMvc.perform(get("/notes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[*].title").value(containsInAnyOrder(
                        "Shopping List",
                        "Archived Note"
                )))
                .andExpect(jsonPath("$[*].archived").value(containsInAnyOrder(false, true)));
    }
}
