package edu.ulima.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
   @Autowired
   UserDetailsServiceImpl userDetailsService;

   
   @Bean
   public BCryptPasswordEncoder passwordEncoder2() {
      BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
      return bCryptPasswordEncoder;
   }

   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
     auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder2());
   }    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console").permitAll();
        
        http.csrf().disable();
        http.headers().frameOptions().disable();
        
        
        http.authorizeRequests()
                .and()
                .formLogin()
                .loginPage("/") //
                .defaultSuccessUrl("/hello") //
                .failureUrl("/error") //
                .usernameParameter("userName") //
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/lgout")
                .logoutSuccessUrl("/success");


    }
    
}
