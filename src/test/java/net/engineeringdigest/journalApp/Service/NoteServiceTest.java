package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Entity.NoteEntity;
import net.engineeringdigest.journalApp.Repository.NoteRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {

    @InjectMocks
    private NoteService noteService;

    @Mock
    private NoteRepository noteRepository;

    @Test
    public void getAllTest(){

        List<NoteEntity> mockNotes = Arrays.asList(
                new NoteEntity(new ObjectId(),"to-do List","Wash Cloths",new Date(),new ObjectId()),
                new NoteEntity(new ObjectId(),"to-do List2","Wash Shoes",new Date(),new ObjectId())
        );

        when(noteRepository.findAll()).thenReturn(mockNotes);

        assertEquals(2,noteService.getAll().size());
    }

    @Test
    public void saveTest(){
        NoteEntity inputNote = new NoteEntity();
        NoteEntity returnNote = new NoteEntity(new ObjectId(),"to-do List","Wash Cloths",new Date(),new ObjectId());

        when(noteRepository.save(any(NoteEntity.class))).thenReturn(returnNote);

        assertTrue(noteService.save(inputNote));

    }

    @ParameterizedTest
    @CsvSource({
            "64c4f9a8e3c84a1bd0a56a9a",
            "64c4f9a8e3c84a1bd0a56a9b"
    })
    public void getByUserIdTest(String idStr){
        ObjectId id = new ObjectId(idStr);
        List<NoteEntity> mockNotes = Arrays.asList(
                new NoteEntity(new ObjectId(),"to-do List","Wash Cloths",new Date(),new ObjectId()),
                new NoteEntity(new ObjectId(),"to-do List2","Wash Shoes",new Date(),new ObjectId())
        );

        when(noteRepository.findAllByUserId(any(ObjectId.class))).thenReturn(mockNotes);

        assertEquals(2,noteService.getByUserId(id).size());
    }

}
