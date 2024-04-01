package com.tasktrace.service;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.tasktrace.configuration.ApplicationConfiguration.REALM_NAME;

@Service
public class KeycloakServiceImpl implements KeycloakService {

    private final Keycloak keycloak;

    public KeycloakServiceImpl(Keycloak keycloak) {
        this.keycloak = keycloak;
    }

    @Override
    public List<UserRepresentation> searchByUserName(String username, boolean exact) {
        List<UserRepresentation> userRepresentations = keycloak.realm(REALM_NAME)
                .users()
                .searchByUsername(username, exact);

        return userRepresentations;
    }
}
