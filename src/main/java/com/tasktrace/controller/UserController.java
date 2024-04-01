package com.tasktrace.controller;

import com.tasktrace.service.KeycloakService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final KeycloakService keycloakService;

    public UserController(KeycloakService keycloakService) {
        this.keycloakService = keycloakService;
    }

    @GetMapping("api/v1/users/{username}")
    List<UserRepresentation> searchByUsername(@PathVariable("username") String username) {
        return keycloakService.searchByUserName(username, true);
    }
}
