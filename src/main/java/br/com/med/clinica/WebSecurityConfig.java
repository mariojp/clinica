package br.com.med.clinica;

import javax.sql.DataSource;

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
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception { // define os acessos
		http.requiresChannel().requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null).requiresSecure();

		http.authorizeRequests().antMatchers("/").permitAll() // recursos permitidos
				.anyRequest().authenticated() // qualquer outro recurso, irá precisar de autenticação
				.and()
				// .formLogin().loginPage("/login").loginProcessingUrl("/logar").permitAll()//permitindo
				// acesso a loginpage personalizada
				.formLogin().permitAll()// permitindo acesso a loginpage default
				.and().logout().permitAll()// permitindo acesso a logout
				.and().csrf().disable(); // desativando uma segurança contra ataques cross-site request

	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {// criando um usuario em memoria, para demonstrar
		UserDetails userDetails = User.withDefaultPasswordEncoder().username("usuario").password("senha").roles("USER")
				.build();

		return new InMemoryUserDetailsManager(userDetails);

		// UserDetailsService sql = new JdbcUserDetailsManager(dataSource);
		// return sql;

		// new UserDetailsService() { //como seria para buscar um user valido no banco,
		// e alocar no
		// userDetails.
		// @Override
		// public UserDetails loadUserByUsername(String username) throws
		// UsernameNotFoundException {
		// select username, senha, papel from usuarios where username = ?
		// return null;
		// }
		// };

	}

//	@Bean
//	public DataSource getDataSource() { // exemplo de como criar um datasource
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//		return dataSource;
//
//	}

}
