package br.com.med.clinica;

import javax.sql.DataSource;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	public DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers("/").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login")
		.loginProcessingUrl("/logar")
		.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.csrf().disable()
		;
	}
	
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
//		UserDetailsService sql = new JdbcUserDetailsManager(dataSource);
//		return sql;
		
		UserDetails userDetails = User.withDefaultPasswordEncoder()
				.username("usuario").password("senha").roles("USER").build();		
		return new InMemoryUserDetailsManager(userDetails); 
	}
	
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource =  new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	
}
