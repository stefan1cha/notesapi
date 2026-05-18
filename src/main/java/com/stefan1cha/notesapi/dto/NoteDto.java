package com.stefan1cha.notesapi.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NoteDto {

    private Long id;

    private String title;

    private String content;

    private Boolean archived;

    private Instant createdAt;

    private Instant updatedAt;
}
