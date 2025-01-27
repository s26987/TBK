package com.app.landingpage.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class SecurityConfig {

    // konfiguracja CSP przeciwko ladowaniu niechcianych skryptow z roznych zrodel
    // wymuszenie https (bezpieczenstwo przesylanych danych)
    // frame options zmienic potencjalnie na deny zeby jeszcze bardziej zabezpieczyc uzytkownika
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                    config.setAllowedHeaders(List.of("*"));
                    config.setAllowCredentials(true);
                    return config;
                }))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/headers/**", "/hero-sections/**", "/about-us/**",
                                "/features/**", "/testimonials/**", "/galleries/**", "/footers/**",
                                "/translations/**", "/personalizations/**", "/contact-forms/**", "/users/**",
                                "/analytics/**", "/media/**").permitAll()
                        .anyRequest().authenticated())
                //zabezpieczenia http(bo wymagania)
                .headers(headers -> headers
                        .contentSecurityPolicy(csp ->
                                csp.policyDirectives("default-src 'self'; img-src 'self' data:; script-src 'self'; style-src 'self' 'unsafe-inline'")
                        )
                        .frameOptions(frame -> frame.sameOrigin()) //w razie pelnej ochrony zmienic na .deny zamiast sameOrigin
                        .referrerPolicy(referrer -> referrer.policy(org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter.ReferrerPolicy.NO_REFERRER))
                        .httpStrictTransportSecurity(hsts ->
                                hsts.includeSubDomains(true).preload(true) // hsts zapewnia bezpieczne polaczenie http
                        )
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}

