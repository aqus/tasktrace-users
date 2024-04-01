package com.tasktrace.configuration;

import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    public static String REALM_NAME = "tasktrace";

    private final String serverUrl;

    private final String clientId;

    private final String clientSecret;

    public ApplicationConfiguration(@Value("${app.keycloak.server-url}") String serverUrl,
                                    @Value("${app.keycloak.client-id}") String clientId,
                                    @Value("${app.keycloak.client-secret}") String clientSecret) {
        this.serverUrl = serverUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(REALM_NAME)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .resteasyClient(new ResteasyClientBuilderImpl()
                        .defaultProxy("localhost", 8180, "http").build())
                .build();
    }
}
