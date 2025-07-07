package net.engineeringdigest.journalApp.Repository;

import net.engineeringdigest.journalApp.Entity.NoteEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository extends MongoRepository<NoteEntity, ObjectId> {
    List<NoteEntity> findAllByUserId(ObjectId userId);
}
