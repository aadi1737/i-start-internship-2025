package net.engineeringdigest.journalApp.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NoteResponseDTO {
    private ObjectId id;
    private String title;
    private String content;
    private Date createdDate;
    private ObjectId userId;
}
