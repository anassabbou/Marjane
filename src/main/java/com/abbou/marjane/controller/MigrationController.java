package com.abbou.marjane.controller;

import com.abbou.marjane.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/migration")
@RequiredArgsConstructor
public class MigrationController {

    private final UserService userService;

    @PostMapping("/migrate-passwords")
    public ResponseEntity<String> migratePasswords() {
        userService.migratePlainTextPasswords();
        return ResponseEntity.ok("Password migration completed successfully.");
    }
}
