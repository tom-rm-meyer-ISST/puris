package org.eclipse.tractusx.puris.backend.common.security;

import org.eclipse.tractusx.puris.backend.common.security.logic.ApiKeyAuthenticationFilter;
import org.eclipse.tractusx.puris.backend.common.security.logic.ApiKeyAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private ApiKeyAuthenticationService apiKeyAuthenticationService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(
                (authorizeHttpRequests) -> authorizeHttpRequests.anyRequest().authenticated()
            )
            .httpBasic(
                AbstractHttpConfigurer::disable
            )
            .sessionManagement(
                (sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .cors(Customizer.withDefaults())
           .addFilterBefore(new ApiKeyAuthenticationFilter(apiKeyAuthenticationService), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }



}
