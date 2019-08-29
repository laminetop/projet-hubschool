package sn.hubschool.users.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig   extends WebSecurityConfigurerAdapter{

    /*
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    */
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{

       authenticationManagerBuilder.userDetailsService(userDetailsService)
       .passwordEncoder(bCryptPasswordEncoder);
}

    @Override
    protected  void configure(HttpSecurity httpSecurity) throws Exception{

     httpSecurity.csrf().disable();
     httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
     httpSecurity.authorizeRequests().antMatchers("/login/**").permitAll();
     httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST,"/users/**").hasAuthority("ADMIN");
     httpSecurity.authorizeRequests().anyRequest().authenticated();
     httpSecurity.addFilter(new JWTAuthenticationFilter(authenticationManager()));
     httpSecurity.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
    }
}
