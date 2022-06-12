package com.velibaba;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration extends AbstractSecurityConfiguration{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**/favicon.ico","/css/**","/js/**","/images/**","/webjars/**"
				,"/login.html" , "/", "/register.html", "/urun-detay**", "/kategori-**"
				, "/urun-kategori-**").permitAll();
		
		http.authorizeRequests().anyRequest().authenticated();
		
		http.formLogin()
			.loginPage("/login.html") //login sayfası adresi
			.loginProcessingUrl("/login") //login.jsp dosyasındaki action değeri.(submit edilecek url)
			.failureUrl("/login.html?loginFailed=true");
			
		//http.rememberMe().userDetailsService(userDetailsService); //beni hatırla
		http.rememberMe()
			.key("re-me-key")
			.rememberMeParameter("remember-me")
			.rememberMeCookieName("rememberlogin")
			.tokenValiditySeconds(86400) //bir gün 
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
	}
	
}
