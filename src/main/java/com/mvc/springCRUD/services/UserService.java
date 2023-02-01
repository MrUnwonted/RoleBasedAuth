package com.mvc.springCRUD.services;

import com.mvc.springCRUD.model.Role;
import com.mvc.springCRUD.model.User;
import com.mvc.springCRUD.repository.RoleRepository;
import com.mvc.springCRUD.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    public void updateUser(Long id,
                              String username,
                              String firstName,
                              String lastName,
                              String password,
                              Role roles
    ){


        User user = userRepository.findByUserId(id);


        if (user==null){
            throw new UsernameNotFoundException("User not found");
        }


        if (firstName != null &&
                firstName.length()>0
//                && !Objects.equals((user.getFirstName()),firstName)
        ){
            user.setFirstName(firstName);
        }

        if (lastName != null &&
                lastName.length()>0 &&
                !Objects.equals((user.getLastName()),lastName)){
            user.setLastName(lastName);
        }

        if (password != null &&
                password.length()>0){
            user.setPassword(passwordEncoder.encode(password));
        }

        if(username != null &&
                username.length()>0 &&
                !Objects.equals(user.getUsername(), username)) {
            User userOptional= userRepository.getUserByUsername(username);
            if (userOptional != null)
                throw new IllegalStateException(("email taken"));
            
            user.addRole(roles);

            user.setUsername(username);
            }

        userRepository.save(user);

        }


    public void registerDefaultUser(User user) {
        Role roleUser = roleRepository.findByName("USER");
        user.addRole(roleUser);
        encodePassword(user);
        System.out.println(user.getFirstName());
        User savedUser = userRepository.save(user);
    }
    public List<User> listAll(){
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

    // dependancy injection
    // IOC container
    // autowired , component, service
    // singleton class
    // REST controller
}
