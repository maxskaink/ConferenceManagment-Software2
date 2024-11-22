package co.edu.unicauca.gateway.Security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class KeycloakRealmRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        // Extraer roles del claim "realm_access.roles" del JWT
        var realmAccess = (Map<String, Object>) jwt.getClaim("realm_access");

        if (realmAccess == null || !realmAccess.containsKey("roles")) {
            return List.of(); // Sin roles
        }

        var roles = (List<String>) realmAccess.get("roles");

        // Convertir roles en SimpleGrantedAuthority
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role)) // Prefijo "ROLE_" necesario en Spring Security
                .collect(Collectors.toList());
    }
}
