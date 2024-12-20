package co.edu.unicauca.gateway.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    private final String jwkSetUri = "http://keycloak:8080/realms/ConferenceMaster/protocol/openid-connect/certs";

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable) // Deshabilitar CSRF para la Gateway.
                .authorizeExchange(exchange -> exchange
                        .pathMatchers(HttpMethod.GET, "/api/users/hello4").permitAll()
                        .pathMatchers(HttpMethod.GET, "/api/users/hello5").hasAuthority("ROLE_error")
                        .pathMatchers(HttpMethod.GET, "/api/articles/conferences/{idConference}").hasAnyAuthority("Organizer")//solo organizer puede listar Artiuclos porconferencia
                        .pathMatchers(HttpMethod.GET, "/api/articles/{idArticle}").hasAnyAuthority("Organizer") // Solo "Organizer" puede listar Articulos por autor
                        .pathMatchers(HttpMethod.PUT, "/api/{idArticle}").hasAnyAuthority( "Organizer", "Author")// Actualizar Articulo
                        .pathMatchers(HttpMethod.DELETE, "/api/{idArticle}").hasAnyAuthority( "Organizer", "Author")// Eliminar Articulo
                        //Confence Controller
                        .pathMatchers(HttpMethod.POST, "/api/conferences").hasAuthority("Organizer")//Solo organizer puede crear una conferencia
                        .pathMatchers(HttpMethod.GET, "/api/conferences").hasAnyAuthority("Organizer", "Author")//.hasAuthority( "Organizer")//Solo organizer puede crear una conferencia
                        .pathMatchers(HttpMethod.GET, "/api/conferences/organizer/{idOrganizer}").hasAnyAuthority("Organizer", "Author")
                        .pathMatchers(HttpMethod.PUT, "/api/conferences/{idOrganizer}").hasAuthority( "Organizer")// Actualizar conferencia
                        .pathMatchers(HttpMethod.GET, "/api/conferences/{idOrganizer}").hasAnyAuthority( "Organizer")// Eliminar conferencia

                        .anyExchange().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(new JwtAuthConverter())))
                .build();
    }

    @Bean
    public ReactiveJwtDecoder jwtDecoder() {
        // Configura un NimbusReactiveJwtDecoder
        NimbusReactiveJwtDecoder jwtDecoder = NimbusReactiveJwtDecoder.withJwkSetUri(jwkSetUri).build();

        // Personaliza la validación
        jwtDecoder.setJwtValidator(jwt -> OAuth2TokenValidatorResult.success());
        return jwtDecoder;
    }

}