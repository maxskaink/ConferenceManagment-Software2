package co.edu.unicauca.gateway.Security;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import reactor.core.publisher.Mono;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class JwtAuthConverter implements Converter<Jwt, Mono<AbstractAuthenticationToken>> {

    private String resourceId = "Microservice-API";


    /**
     * Convierte un objeto Jwt en un AbstractAuthenticationToken.
     *
     * @param jwt el objeto Jwt a convertir.
     * @return el AbstractAuthenticationToken convertido.
     */
    @Override
    public Mono<AbstractAuthenticationToken> convert(Jwt jwt) {

        Collection<GrantedAuthority> authorities = extractResourceRoles(jwt);

        return Mono.just(new JwtAuthenticationToken(jwt, authorities));

    }


    /**
     * Extrae los roles de recursos del JWT.
     *
     * @param jwt el objeto Jwt del que se extraen los roles.
     * @return una colección de GrantedAuthority correspondiente a los roles.
     */
    @SuppressWarnings("unchecked")
    private Collection<GrantedAuthority> extractResourceRoles(Jwt jwt) {
        Map<String, Object> resourceAccess;
        Map<String, Object> resource;
        Collection<String> resourceRoles;

        // Extrae el acceso a los recursos del JWT.
        resourceAccess = jwt.getClaim("resource_access");

        if (resourceAccess == null) {
            return List.of();
        }

        // Extrae los recursos específicos por ID.
        resource = (Map<String, Object>) resourceAccess.get(resourceId);

        if (resource == null) {
            return List.of();
        }

        if (resource.get("roles") == null) {
            return List.of();
        }

        // Obtiene los roles del recurso.
        resourceRoles = (Collection<String>) resource.get("roles");

        return resourceRoles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}