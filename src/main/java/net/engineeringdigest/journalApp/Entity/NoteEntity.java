package net.engineeringdigest.journalApp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Notes")
public class NoteEntity {

    private ObjectId id;
    private String title;
    private String content;

    @CreatedDate
    private Date createdDate;

    private ObjectId userId;
}
