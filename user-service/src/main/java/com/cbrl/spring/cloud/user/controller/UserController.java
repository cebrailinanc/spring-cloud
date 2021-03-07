package com.cbrl.spring.cloud.user.controller;

import com.cbrl.spring.cloud.user.model.User;
import com.cbrl.spring.cloud.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repository;

    @GetMapping("/{user-id}")
    public ResponseEntity<Boolean> isForbidden(@PathVariable("user-id") Long id) {
        log.info("called user-service...........");
        Optional<User> entity = repository.findById(id);

        if (entity.isPresent())
            return ResponseEntity.ok(entity.get().getForbidden());
        return ResponseEntity.ok(Boolean.FALSE);
    }
}
