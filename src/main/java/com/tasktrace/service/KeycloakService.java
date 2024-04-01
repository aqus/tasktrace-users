package com.tasktrace.service;



import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public interface KeycloakService {

    List<UserRepresentation> searchByUserName(String username, boolean exact);
}
