package net.engineeringdigest.journalApp.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "User")
@Builder
public class UserEntity {

    @Id
    private ObjectId id;
    private String userName;
    private String password;
    private String role;

}
