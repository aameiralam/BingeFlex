package com.finalProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtAutheticationFilter autheticationFilter;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(c -> c.disable())
                .cors(c -> c.configurationSource(corsFilter()))
                .authorizeHttpRequests(c -> c
//                       .requestMatchers(HttpMethod.GET, "/api/v1/movie/**").permitAll() // Allow all users to view movie cards
//                       .requestMatchers(HttpMethod.POST, "/api/v1/movie/**").hasRole("ADMIN") // Admins can add movies
//                        .requestMatchers(HttpMethod.PUT, "/api/v1/movie/update").hasRole("ADMIN") // Admins can update movies
//                        .requestMatchers(HttpMethod.DELETE, "/api/v1/movie/delete/**").hasRole("ADMIN") // Admins can delete movies
//                       .requestMatchers("/api/v1/auth/**").permitAll() // Login and registration are public
//                       .anyRequest().authenticated()
//                )


//                .requestMatchers(HttpMethod.GET, "/api/v1/movie/**").permitAll()
//                .requestMatchers(HttpMethod.POST, "/api/v1/auth/*").permitAll()
//                .requestMatchers(HttpMethod.PUT, "/api/v1/movie/update").hasRole("USER")
//                .requestMatchers(HttpMethod.DELETE, "/api/v1/movie/delete/*").hasRole("ADMIN")
//                .anyRequest().authenticated()
                .anyRequest().permitAll()
                )

                .sessionManagement(ses -> ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(autheticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }

    @Bean
   public UrlBasedCorsConfigurationSource corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(List.of("http://localhost:5173","http://127.0.0.1:5173"));
       configuration.addAllowedHeader("*");
       configuration.addAllowedMethod("*");
       source.registerCorsConfiguration("/**", configuration);




        return source;
    }


}



