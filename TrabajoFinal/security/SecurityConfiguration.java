package edu.pe.utp.TrabajoFinal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Aqui se crea el vinculo entre el Spring security y el PasswordEncoder y UserDetailsService
		DaoAuthenticationProvider authenticationProvider() {
			DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
			
			daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
			daoAuthenticationProvider.setUserDetailsService(this.myUserDetailsService);
			return daoAuthenticationProvider;
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.authenticationProvider(authenticationProvider());
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
	
		http
		.authorizeRequests()
		.antMatchers("/oulala").permitAll();
		http
		.authorizeRequests()
		.antMatchers("/oulala/index/login").hasAnyRole("CUSTOMER","ADMIN")
		.antMatchers("/oulala/proveedor/manteminientoProveedores","/oulala/proveedor/manteminientoProveedores").hasAnyRole("ADMIN")
		.antMatchers("/oulala/producto/manteminientoProductos","/oulala/producto/manteminientoProductos").hasAnyRole("ADMIN")
		.antMatchers("/oulala/cliente/lista","/oulala/cliente/lista").hasAnyRole("ADMIN")
		.and()
		
		// .formLogin()
         //.loginPage("/oulala/login")
         //.failureUrl("/oulala/login?error=true") // Redirigir con el parámetro "error"
        //.defaultSuccessUrl("/oulala/index/login", true)
         	
		
		.formLogin()
		.loginProcessingUrl("/signin").defaultSuccessUrl("/oulala/index")
		.loginPage("/oulala/login")
		.failureUrl("/oulala/login?error=true") // Redirigir con el parámetro "error"
		.usernameParameter("username")
		.passwordParameter("password")
		
		 .and()
		 .logout()
		 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		 .logoutSuccessUrl("/oulala/index")
		;		
		}

		
		
}