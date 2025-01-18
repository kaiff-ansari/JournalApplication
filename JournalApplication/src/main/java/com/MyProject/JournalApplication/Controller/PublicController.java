package com.MyProject.JournalApplication.Controller;

import com.MyProject.JournalApplication.Entity.User;
import com.MyProject.JournalApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "Ok";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User myEntry){
        userService.saveNewUser(myEntry);

    }

}
