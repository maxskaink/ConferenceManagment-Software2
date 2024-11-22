package co.edu.unicauca.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    /**
     * Configura la cadena de filtros de seguridad para la aplicación, estableciendo
     * las reglas de autorización y la validación de tokens JWT mediante Keycloak.
     *
     * @param http         Configuración de seguridad HTTP proporcionada por Spring Security.
     * @param jwtConverter Conversor personalizado de JWT a una instancia de Authentication.
     * @return La cadena de filtros de seguridad configurada.
     * @throws Exception Si ocurre algún error durante la configuración de seguridad.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtConverter jwtConverter) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/conferences/**").hasAnyRole("Author", "Organizer") // Permitir ambos roles
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .decoder(jwtDecoder())
                                .jwtAuthenticationConverter(jwtConverter)
                        )
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }
    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri("http://localhost:9090/realms/ConferenceMaster/protocol/openid-connect/certs").build();
    }

}
