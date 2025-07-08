package net.engineeringdigest.journalApp.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteRequestDTO {
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Content is Required")
    private String content;
}
