package com.example.javaDevModule15.repositories;

import com.example.javaDevModule15.entities.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NoteService implements INoteService {
    Map<Long, Note> notes = new ConcurrentHashMap<>();

    @Override
    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    @Override
    public Note add(Note note) {
        long id = generateUniqueId();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    @Override
    public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist");
        }
        notes.remove(id);
    }

    @Override
    public void update(Note note) {
        if (!notes.containsKey(note.getId())) {
            throw new IllegalArgumentException("Note with id " + note.getId() + " does not exist");
        }
        notes.put(note.getId(), note);
    }

    @Override
    public Note getById(long id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist");
        }
        return notes.get(id);
    }

    private long generateUniqueId() {
        Random random = new Random();
        return random.nextInt(1000);
    }
}
