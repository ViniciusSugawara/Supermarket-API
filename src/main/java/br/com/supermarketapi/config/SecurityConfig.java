package br.com.supermarketapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@EnableWebSecurity
@Configuration
public class SecurityConfig{

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeHttpRequests((authz) -> authz.requestMatchers(HttpMethod.POST, "/product").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.GET,"/products", "/product/**").hasRole("ADMIN")
                            .anyRequest().fullyAuthenticated()
                    )
                    .httpBasic(withDefaults());
            return http.build();
        }
        @Bean
        public InMemoryUserDetailsManager userDetailsService() {
            UserDetails user = User.withDefaultPasswordEncoder()
                    .username("user")
                    .password("password")
                    .roles("USER")
                    .build();
            UserDetails user2 = User.withDefaultPasswordEncoder()
                    .username("admin")
                    .password("password")
                    .roles("ADMIN", "USER")
                    .build();
            return new InMemoryUserDetailsManager(user, user2);
        }
}
