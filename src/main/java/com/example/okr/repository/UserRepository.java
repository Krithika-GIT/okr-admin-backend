package com.example.okr.repository;
import com.example.okr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndEmail(String username, String email);
    List<User> findByObjectiveId(Long objectiveId);
    Optional<User> findByUsername(String username);

}
