package com.apirest.autorentax.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    http.requestMatchers(HttpMethod.GET, "/api/vehicle/viewVehicles").permitAll();
                    http.requestMatchers(HttpMethod.POST, "/api/rent-vehicles/add").permitAll();

                    http.requestMatchers(HttpMethod.PUT, "/api/rent-vehicles/update/{id}").hasRole("CLIENT");
                    http.requestMatchers(HttpMethod.GET, "/api/rent-vehicles/viewRents").hasRole("CLIENT");

                    http.requestMatchers(HttpMethod.GET, "/api/**").hasRole("ADMIN");
                    http.requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN");
                    http.requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN");
                    http.requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN");

                    http.anyRequest().authenticated();
                })
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());

        return provider;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        List<UserDetails> userDetails = new ArrayList<UserDetails>();

        userDetails.add(User.withUsername("danielamendez@gmail.com")
                .password("ndma")
                .roles("ADMIN")
                .authorities("READ, UPDATE, DELETE, CREATE")
                .build());

        userDetails.add(User.withUsername("ramiro@gmail.com")
                .password("ramiro")
                .roles("CLIENT")
                .authorities("READ, UPDATE, DELETE, CREATE")
                .build());

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder(passwordEncoder);
        return NoOpPasswordEncoder.getInstance();
    }
}
