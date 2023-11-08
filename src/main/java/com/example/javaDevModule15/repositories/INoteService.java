package com.example.javaDevModule15.repositories;

import com.example.javaDevModule15.entities.Note;
import java.util.List;

public interface INoteService {
    public List<Note> listAll();

    public Note add(Note note);

    public void deleteById(long id);

    public void update(Note note);

    public Note getById(long id);
}
