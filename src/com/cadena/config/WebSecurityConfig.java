package com.cadena.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@ComponentScan(basePackages = { "com.cadena" })
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("____ WebSecurityConfig_18");
		/*
		 * http.authorizeRequests().antMatchers("/login").permitAll().anyRequest().
		 * authenticated().and().formLogin()
		 * .loginPage("/login").defaultSuccessUrl("/login").permitAll().failureUrl(
		 * "/login").permitAll().and() .csrf().disable();
		 * http.logout().logoutUrl("/logout").logoutSuccessUrl("/index").
		 * invalidateHttpSession(true);
		 */
		http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER").and().authorizeRequests()
				.antMatchers("/login**").permitAll().and().formLogin().loginPage("/login")
				.loginProcessingUrl("/loginAction").permitAll().and().logout().logoutSuccessUrl("/login").permitAll()
				.and().csrf().disable();
		http.logout().logoutUrl("/logoutAction").logoutSuccessUrl("/login").invalidateHttpSession(true);
		System.out.println("____ WebSecurityConfig_45");
	}

}