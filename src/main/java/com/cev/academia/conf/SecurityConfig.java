package com.cev.academia.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//Como es una clase de configuracion llevará el decordador Configuration
@Configuration
//Habilitamos la seguridad con el decorador EnableWebSecurity
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/**")  //Todos los get podran hacerlos usuarios y administradores
		.hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
		//Todas las demas peticiones que no sea get solo podran acceder el admin
		.anyRequest().hasAuthority("ROLE_ADMIN")
		.and().httpBasic(); //Esto es el tipo de autentificacion que vamos a usar, es decir, pedir usuario y contraseña.
	}
	
	//Implementamos el metodo configureGlobal y le pasamos un objeto de tipo AuthenticationManagerBuilder.
	//Aqui definiremos los usuarios con diferentes roles.
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception{
		//Le decimos que la authentication va a ser en memoria
		authentication.inMemoryAuthentication()
		//Definimos los usuarios 
		.withUser("admin")
		.password(passwordEncoder().encode("12345")) //Con passwordEncoder ciframos la contraseña
		.authorities("ROLE_ADMIN") //LE damos el rol de administrador
		.and()
		.withUser("user")
		.password(passwordEncoder().encode("12345")) //Con passwordEncoder ciframos la contraseña
		.authorities("ROLE_USER"); //Le damos un rol de usuario normal	
	}
	
	//Vamos a cifrar el password. Esto devuelve una instancia del enconder.
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
