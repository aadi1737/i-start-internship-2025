package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Entity.NoteEntity;
import net.engineeringdigest.journalApp.Repository.NoteRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Disabled
@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public List<NoteEntity> getAll(){
        List<NoteEntity> all = noteRepository.findAll();
        return all;
    }

    public boolean save(NoteEntity note){
        NoteEntity save = noteRepository.save(note);
        return save!=null;
    }

    public List<NoteEntity> getByUserId(ObjectId id){
        List<NoteEntity> notes = noteRepository.findAllByUserId(id);
        return notes;
    }

}
