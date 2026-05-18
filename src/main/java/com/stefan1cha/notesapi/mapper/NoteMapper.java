package com.stefan1cha.notesapi.mapper;

import com.stefan1cha.notesapi.dto.NoteDto;
import com.stefan1cha.notesapi.entity.Note;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NoteMapper {

    NoteMapper INSTANCE = Mappers.getMapper(NoteMapper.class);

    NoteDto noteToNoteDto(Note note);

    Note noteDtoToNote(NoteDto noteDto);
}
