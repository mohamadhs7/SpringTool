package com.jrp.pma.Security;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	javax.sql.DataSource datasource;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
		
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//	auth.inMemoryAuthentication()
//			auth.jdbcAuthentication().dataSource(datasource)
//			.withDefaultSchema()
//			.withUser("mohamad")
//			.password("zedanesh79")
//			.roles("USER")
//			.and()
//			.withUser("usr")
//			.password("zedanesh79")
//			.roles("ADMIN");
		
		auth.jdbcAuthentication()
		.usersByUsernameQuery("select username, password, enabled"+
		" from user_accounts where username = ?" )
		.authoritiesByUsernameQuery("select username, role"+
		" from user_accounts where username = ?")
		.dataSource(datasource)
		.passwordEncoder(bCryptEncoder);		
	}
	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	protected void configure (HttpSecurity http)throws Exception{
		http.authorizeRequests()
			.antMatchers("/projects/new").hasRole("ADMIN")
			.antMatchers("/projects/save").hasRole("ADMIN")
			.antMatchers("/employees/new").hasAuthority("ADMIN")
			.antMatchers("/employees/save").hasAuthority("ADMIN")
			//.antMatchers("/h2_console/**").permitAll()
			.antMatchers("/","/**").permitAll()
			.and()
			.formLogin();
		
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
	}
}