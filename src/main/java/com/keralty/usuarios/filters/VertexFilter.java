package com.keralty.usuarios.filters;

import jakarta.inject.Inject;

import org.eclipse.microprofile.jwt.JsonWebToken;

import com.keralty.usuarios.security.TokenService;

import io.quarkus.vertx.web.RouteFilter;
import io.vertx.ext.web.RoutingContext;

public class VertexFilter {

	static final String AUTHORIZATION_HEADER = "Authorization";
	
	static final String BEARER_PREFIX = "Bearer ";
	
    @Inject
    JsonWebToken jwt;

    @Inject
    TokenService tokenService;
    
    @RouteFilter
    void addUpdatedJWTToResponse(RoutingContext rc) {
        String authorizationHeader = rc.request().getHeader(AUTHORIZATION_HEADER);
        if (authorizationHeader != null && jwt != null) {
            rc.response().putHeader(AUTHORIZATION_HEADER, BEARER_PREFIX + tokenService.renew(jwt));
        }
        rc.next();
    }
    
}
