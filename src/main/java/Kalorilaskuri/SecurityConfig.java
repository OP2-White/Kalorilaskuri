package Kalorilaskuri;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
 
@Configuration
public class SecurityConfig {
 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF protection since we're allowing access to all endpoints freely
            .csrf().disable()
            // Configure HTTP security to permit all requests
            .authorizeHttpRequests((authz) -> authz
                .anyRequest().permitAll() // This line replaces the deprecated antMatchers approach
            );
        return http.build();
    }
 
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}