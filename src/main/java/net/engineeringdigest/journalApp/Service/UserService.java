package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Entity.UserEntity;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserEntity> getAll(){
        List<UserEntity> allUser = userRepository.findAll();
        return allUser;
    }

    public boolean save(UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity saved = userRepository.save(user);
        return saved!=null;
    }

    public UserEntity getById(ObjectId id){
        Optional<UserEntity> byId = userRepository.findById(id);
        return byId.orElse(null);
    }



}
