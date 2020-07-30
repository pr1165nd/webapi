package com.example.webapi.Controller;

import com.example.webapi.Models.Message;
import com.example.webapi.Models.User;
import com.example.webapi.Services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired Message message;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUser(){return userRepository.findAll(); }


    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUsers(@PathVariable Long id) {
        userRepository.deleteById(id);
        return id + "Deleted";

    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Message adduser(@RequestBody final User u){
       userRepository.save(u);
       message.setStatus("Added");
       return message;
    }

    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Message edituser(@RequestBody final User us,@PathVariable Long id){
        us.setId(id);
        userRepository.save(us);
        message.setStatus("Edited");
        return message;
    }
}
