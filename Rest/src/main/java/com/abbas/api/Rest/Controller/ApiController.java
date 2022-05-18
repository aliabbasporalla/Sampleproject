package com.abbas.api.Rest.Controller;

import com.abbas.api.Rest.Model.User;
import com.abbas.api.Rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping(value = "/")
    public String getpage(){
        return "welcome";
    }
    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) {

        userRepo.save(user);
        return "saved...";
    }
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id ,@RequestBody  User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);
        return "updated..!!";

    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser =userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return  "Delete user with ID"+id;
    }
}




