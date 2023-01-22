package com.vitoria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	 	@Autowired
	    private UserDetailsService userDetailsService;

	    @Bean
	    AuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider provider
	                 = new DaoAuthenticationProvider();
	        provider.setUserDetailsService(userDetailsService);
	        provider.setPasswordEncoder(new BCryptPasswordEncoder());
	        return  provider;
	    }
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	 http
	            .authorizeRequests()
	            .antMatchers(HttpMethod.POST, "/**")
	            .hasAuthority("ADMIN")
	            .antMatchers(HttpMethod.DELETE, "/**")
	            .hasAuthority("ADMIN")
	            .antMatchers(HttpMethod.PUT, "/**")
	            .hasAuthority("ADMIN")
	            .antMatchers(HttpMethod.GET, "/**")
	            .hasAuthority("ADMIN") 
	            .antMatchers(HttpMethod.GET, "/tools")
	            .hasAuthority("USER")
	            .anyRequest()
	            .authenticated()
	            .and()
	            .cors()
	            .and()
	            .exceptionHandling()
	            .and()
	            .sessionManagement()
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            .and()
	            .csrf()
	            .disable();

	    }

  
}
