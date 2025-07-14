package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Entity.UserEntity;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username);
        if(user!=null){
            UserDetails userDetails = User.builder()
                    .username(user.getUserName())
                    .password(user.getPassword())
                    .roles(user.getRole())
                    .build();
            return userDetails;
        }
        throw new UsernameNotFoundException("nahi mila !"+username+" Name ka User to mai bhi kya kar skat hu!");
    }
}
