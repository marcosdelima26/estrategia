package teste;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * https://gist.github.com/thomasdarimont/860a8a8420762c14d57766425b036c13
 */
class CustomKeycloakAuthenticationProvider extends KeycloakAuthenticationProvider {


	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) authentication;
        Collection<? extends GrantedAuthority> keycloakAuthorities = addUserSpecificAuthorities(token);
        return new KeycloakAuthenticationToken(token.getAccount(), token.isInteractive(), keycloakAuthorities);
    }

    protected Collection<? extends GrantedAuthority> addUserSpecificAuthorities( KeycloakAuthenticationToken token) {


        List<GrantedAuthority> result = new ArrayList<>();

        KeycloakPrincipal<KeycloakSecurityContext> keycloakPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) token
                .getPrincipal();
        for (String role : keycloakPrincipal.getKeycloakSecurityContext().getToken().getResourceAccess("GUIA").getRoles()) {

            result.add(new SimpleGrantedAuthority(role));
        }
        return result;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return KeycloakAuthenticationToken.class.isAssignableFrom(aClass);
    }
}