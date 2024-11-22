package co.edu.unicauca.gateway.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;

import java.util.Collection;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = new KeycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }
    @Bean
    public NullAuthenticatedSessionStrategy sessionAuthenticationStrategy() {
        // Estrategia de sesión para aplicaciones sin estado
        return new NullAuthenticatedSessionStrategy();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("entra aqui11111111111111111111111111111111111");
        http.csrf(csrf -> csrf.disable()) // Desactiva CSRF
                .sessionManagement(session -> // Configura la gestión de sesiones
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Uso sin estado (para JWT y OAuth2)
                .authorizeHttpRequests(auth -> auth // Configura autorización
                .requestMatchers(HttpMethod.POST, "/api/articles/conferences/{idConference}").hasAnyAuthority("Organizer", "Author")// Crear Articulo
                .requestMatchers(HttpMethod.GET, "/api/articles/author/{idAuthor}").hasAuthority( "Organizer")// Solo "Organizer" puede listar articulos por conferencias
                .requestMatchers(HttpMethod.GET, "/api/articles/{idArticle}").hasAuthority( "Organizer")// Solo "Organizer" puede listar Articulos por autor
                .requestMatchers(HttpMethod.PUT, "/api/{idArticle}").hasAnyAuthority( "Organizer", "Author")// Actualizar Articulo
                .requestMatchers(HttpMethod.DELETE, "/api/{idArticle}").hasAnyAuthority( "Organizer", "Author")// Eliminar Articulo
                //ConferenceController
                .requestMatchers(HttpMethod.POST, "/api/conferences").hasAuthority( "Organizer")//Solo organizer puede crear una conferencia
                .requestMatchers(HttpMethod.GET, "/api/conferences").hasRole("Organizer")// obtener conferencias
                .requestMatchers(HttpMethod.GET, "/api/conferences/organizer/{idOrganizer}").hasAuthority( "Organizer")// obtener conferencia por Organizador
                .requestMatchers(HttpMethod.PUT, "/api/conferences/{idOrganizer}").hasAuthority( "Organizer")// Actualizar conferencia
                .requestMatchers(HttpMethod.GET, "/api/users").hasAnyAuthority( "Organizer")// Eliminar conferencia.requestMatchers(HttpMethod.GET, "/api/conferences/{idOrganizer}").hasAnyAuthority( "Organizer")// Eliminar conferencia

                        .anyRequest().authenticated() )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(new JwtAuthenticationConverter())));
// Todas las demás rutas requieren autenticación
                        // Configura el servidor de recursos OAuth2 con validación de JWT

        return http.build();
    }
    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new KeycloakRealmRoleConverter()); // Usa el convertidor personalizado
        return converter;
    }
}

