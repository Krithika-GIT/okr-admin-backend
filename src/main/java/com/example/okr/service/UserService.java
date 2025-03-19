package com.example.okr.service;
import com.example.okr.entity.User;
import com.example.okr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUsers(List<User> users) {
        for (User user : users) {
            user.setGroupId(user.getObjectiveId()); // Ensuring groupId matches objectiveId
        }
        userRepository.saveAll(users);
    }




    public boolean removeUser(String username, String email) {
        Optional<User> user = userRepository.findByUsernameAndEmail(username, email);
        if (user.isPresent()) {
            userRepository.delete(user  .get());
            return true;
        }
        return false;
    }
    public List<User> getUsersByObjectiveId(Long objectiveId) {
        return userRepository.findByObjectiveId(objectiveId);
    }
    public boolean canAssignTask(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent() && "Program Director".equals(user.get().getRole());
    }
}