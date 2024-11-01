package com.example.mozispring.repository;

import com.example.mozispring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByFelhaszlonev(String felhaszlonev);
}
