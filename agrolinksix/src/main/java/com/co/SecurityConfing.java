
package com.co;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author adria
 */

@Configuration
@EnableWebSecurity
public class SecurityConfing extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}1234")
                .roles("ADMIN");
        
                auth.inMemoryAuthentication()
                .withUser("free")
                .password("{noop}1234")
                .roles("FREE");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/administrador")
                    .hasRole("ADMIN")
                .and()
                    .formLogin()
                        .loginPage("/login")
                .defaultSuccessUrl("/administrador")
                .permitAll()
                ;
        http.authorizeRequests()
                        .antMatchers("/freelancer")
                    .hasRole("FREE")
                .and()
                    .formLogin()
                        .loginPage("/login")
                .defaultSuccessUrl("/freelancer")
                .permitAll()
                ;
    }
}
