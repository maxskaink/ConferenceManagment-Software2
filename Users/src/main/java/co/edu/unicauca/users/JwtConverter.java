package co.edu.unicauca.users;

import lombok.NonNull;
import lombok.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JwtConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter =
            new JwtGrantedAuthoritiesConverter();

    private final   String principleAttribute = "preferred_username";

    private  final String resourcesId = "Microservice-API";



    @Override
    public AbstractAuthenticationToken convert(@NonNull Jwt jwt) {
        Collection<GrantedAuthority> authorities = Stream.concat(
                jwtGrantedAuthoritiesConverter.convert(jwt).stream(),
                extractResourceRoles(jwt).stream()
        ).collect(Collectors.toSet());
        return new JwtAuthenticationToken(jwt, authorities,
                getPrincipleClaimName(jwt));
    }
    private String getPrincipleClaimName(Jwt jwt){
        String claimName = JwtClaimNames.SUB;
        if(principleAttribute != null)
            claimName = principleAttribute;

        return jwt.getClaim(claimName);

    }

    public Collection<? extends GrantedAuthority> extractResourceRoles(Jwt jwt) {
        Map<String, Object> resourceAcces;
        Map<String, Object> resources;
        Collection<String> resourceRoles;
        if(jwt.getClaim("resource_acces") == null)
            return Set.of();
        resourceAcces = jwt.getClaim("resource_acces");
        if(resourceAcces.get(resourcesId) == null)
            return Set.of();
        resources  = (Map<String, Object>) resourceAcces.get(resourcesId);

        resourceRoles = (Collection<String>) resourceAcces.get("roles");

        return resourceRoles
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE" + role)).collect(Collectors.toSet());
    }
}
