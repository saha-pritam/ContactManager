package org.pritam.contactManager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    @SuppressWarnings({"removal", "deprecation"})
    SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		.authorizeRequests()
		.requestMatchers("/authenticated/**")
		.hasAnyAuthority("USER")
		.anyRequest()
		.permitAll()
		.and()
		.formLogin()
		.loginPage("/signin")
		.defaultSuccessUrl("/authenticated/showContacts");
		return http.build();
	}
    
    @Bean
    AuthenticationManager getAuthenticationManager(AuthenticationConfiguration authenticationConfiguration)throws Exception {
    	return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    PasswordEncoder getPasswordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
