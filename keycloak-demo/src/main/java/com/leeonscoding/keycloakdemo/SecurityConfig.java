package com.leeonscoding.keycloakdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/admin/**").hasRole("app_admin")
                        .requestMatchers("/api/user/**").hasRole("app_user")
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(rs -> rs.jwt(customizer -> customizer.jwtAuthenticationConverter(source -> {
                    Map<String, Object> claim = source.getClaimAsMap("resource_access");
                    Map<String, Object> realm = (Map<String, Object>) claim.get("todo-web");
                    Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>) realm.get("roles");


                    return new TokenConverter(roles);
                })) )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
                /*.oauth2ResourceServer(rs -> rs.jwt(customizer -> customizer.jwtAuthenticationConverter(source -> {
                    Map<String, Object> claim = source.getClaimAsMap("resource_access");
                    Map<String, Object> realm = (Map<String, Object>) claim.get("todo-web");
                    List<String> roles = (List<String>) realm.get("roles");

                    return new A
                })) )*/
    }

    private class MapJSONToken {

    }

    private class TokenConverter extends AbstractAuthenticationToken {

        public TokenConverter(Collection<? extends GrantedAuthority> authorities) {
            super(authorities);
        }

        @Override
        public Object getCredentials() {
            return null;
        }

        @Override
        public Object getPrincipal() {
            return null;
        }
    }
}
