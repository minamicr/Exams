package br.com.minami.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.minami.service.CustomUserDetailService;


///////https://www.baeldung.com/spring-boot-security-autoconfiguration
///////https://docs.spring.io/spring-security/site/docs/5.0.5.RELEASE/reference/htmlsingle/

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			//.anyRequest().authenticated()
			.antMatchers("/*/protected/**").hasRole("USER")
			.antMatchers("/*/admin/**").hasRole("ADMIN")
			.and()
			.httpBasic()
			.and()
			.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	/*
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		// auth.inMemoryAuthentication()
		//	.withUser("cristina").password("pakatumm").roles("USER")
		//	.and()
		//	.withUser("admin").password("pakatumm").roles("USER", "ADMIN");

		 PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		 auth.inMemoryAuthentication()
		          .withUser("cristina")
		          .password(encoder.encode("pakatumm"))
		          .roles("USER")
		          .and()
		          .withUser("admin")
		          .password(encoder.encode("pakatumm"))
		          .roles("USER", "ADMIN");
	}
	*/
}
