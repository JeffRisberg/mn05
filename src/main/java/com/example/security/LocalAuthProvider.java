package com.example.security;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.Collections;
import java.util.Optional;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Singleton
public class LocalAuthProvider implements AuthenticationProvider {

  @Inject IdentityStore store;

  @Override
  public Publisher<AuthenticationResponse> authenticate(
      @Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
    String username = authenticationRequest.getIdentity().toString();
    String password = authenticationRequest.getSecret().toString();

    System.out.println("username: " + username);
    System.out.println("password: " + password);

    return Flux.create(
        emitter -> {
          if (password.equals(store.getUserPassword(username))) {
            System.out.println("match");
            emitter.next(AuthenticationResponse.success
              (username, Collections.singletonList(store.getUserRole(username))));
            emitter.complete();
          } else {
            System.out.println("no match");
            emitter.error(AuthenticationResponse.exception());
          }
        },
        FluxSink.OverflowStrategy.ERROR);
  }
}
