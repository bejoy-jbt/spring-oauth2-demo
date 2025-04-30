package org.example.springoauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean(name = "customSecurityFilterChain")

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login").permitAll() // allow these without auth
                        .anyRequest().authenticated()
                )
                .oauth2Login(Customizer.withDefaults()) // enable OAuth2 login
                .oauth2Client(Customizer.withDefaults()); // optional if you're only logging in

        return http.build();
    }

}

