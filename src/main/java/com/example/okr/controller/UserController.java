package com.example.okr.controller;


import com.example.okr.entity.User;
import com.example.okr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="http://10.106.24.19")
@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUsers")
    public ResponseEntity<String> addUsers(@RequestBody List<User> users) {
        userService.addUsers(users);
        return ResponseEntity.ok("Users added successfully");
    }

    @DeleteMapping("/removeUser")
    public ResponseEntity<String> removeUser(@RequestParam String username, @RequestParam String email) {
        boolean removed = userService.removeUser(username, email);
        if (removed) {
            return ResponseEntity.ok("User removed successfully");
        } else {
            return ResponseEntity.badRequest().body("User not found");
        }
    }
    @PostMapping("/assignTask")
    public ResponseEntity<String> assignTask(@RequestParam String username) {
        if (!userService.canAssignTask(username)) {
            return ResponseEntity.status(403).body("You do not have permission to assign tasks.");
        }
        return ResponseEntity.ok("Task assigned successfully.");
    }
    @GetMapping("/usersByObjective")
    public ResponseEntity<List<User>> getUsersByObjective(@RequestParam Long objectiveId) {
        List<User> users = userService.getUsersByObjectiveId(objectiveId);
        return ResponseEntity.ok(users);
    }


}