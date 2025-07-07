package net.engineeringdigest.journalApp.Controllers;

import net.engineeringdigest.journalApp.DTOs.NoteRequestDTO;
import net.engineeringdigest.journalApp.DTOs.NoteResponseDTO;
import net.engineeringdigest.journalApp.Entity.NoteEntity;
import net.engineeringdigest.journalApp.Entity.UserEntity;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import net.engineeringdigest.journalApp.Service.NoteService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("note")
@RestController
public class NoteController {

    @Autowired
    NoteService noteService;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<NoteResponseDTO> getAllNotes(){
        List<NoteEntity> notes = noteService.getAll();
        List<NoteResponseDTO> dtoList = new ArrayList<>();
        for(NoteEntity note:notes){
            NoteResponseDTO dto = new NoteResponseDTO();
            dto.setId(note.getId());
            dto.setTitle(note.getTitle());
            dto.setContent(note.getContent());
            dto.setUserId(note.getUserId());
            dto.setCreatedDate(note.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }
    @PostMapping
    public ResponseEntity<?> createNote(@RequestBody NoteRequestDTO dto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserEntity user = userRepository.findByUserName(username);
        ObjectId id = user.getId();
        NoteEntity note = new NoteEntity();
        note.setUserId(id);
        note.setContent(dto.getContent());
        note.setTitle(dto.getTitle());
        boolean save = noteService.save(note);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping("/my")
    public List<NoteResponseDTO> getLoggedUserNote(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserEntity user = userRepository.findByUserName(username);
        ObjectId id = user.getId();
        List<NoteEntity> notes = noteService.getByUserId(id);
        List<NoteResponseDTO> dtoList = new ArrayList<>();
        for (NoteEntity byUserId:notes) {
            NoteResponseDTO dto = new NoteResponseDTO();
            dto.setId(byUserId.getId());
            dto.setTitle(byUserId.getTitle());
            dto.setContent(byUserId.getContent());
            dto.setUserId(user.getId());
            dtoList.add(dto);
        }
        return dtoList;
    }


}
