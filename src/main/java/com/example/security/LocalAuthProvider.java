package com.example.security;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Singleton
public class LocalAuthProvider implements AuthenticationProvider {

  @Inject
  IdentityStore store;

  @Override
  public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest,
                                                        AuthenticationRequest<?, ?> authenticationRequest) {
    String username = authenticationRequest.getIdentity().toString();
    String password = authenticationRequest.getSecret().toString();

    return Flux.create(emitter -> {
      if (password.equals(store.getUserPassword(username))) {
        emitter.next(AuthenticationResponse.success((String) authenticationRequest.getIdentity()));
        emitter.complete();
      } else {
        emitter.error(AuthenticationResponse.exception());
      }
    }, FluxSink.OverflowStrategy.ERROR);
  }
}
