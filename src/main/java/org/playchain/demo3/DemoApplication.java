package org.playchain.demo3;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RestController
//@EnableResourceServer
//@EnableAuthorizationServer
@MapperScan("org.playchain.demo3.mapper")
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

/*	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.formLogin().loginPage("/login").permitAll().failureUrl("/login")
				.and()
				.csrf().disable()
				.authorizeRequests()
//				.antMatchers("/user").permitAll()
				.anyRequest().authenticated()
				.and()
				.logout()
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true)
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.and()
				.httpBasic();
	}*/

/*
	@Autowired
	public void configGobal(AuthenticationManagerBuilder auth) 	throws Exception {
		auth.inMemoryAuthentication().withUser("bar").password("barsecret").roles("USER");
	}
*/

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



}
