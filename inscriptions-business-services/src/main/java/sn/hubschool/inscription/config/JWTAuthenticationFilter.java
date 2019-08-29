package sn.hubschool.users.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sn.hubschool.users.models.AppUser;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{


    private AuthenticationManager authenticationManager;

   public JWTAuthenticationFilter(AuthenticationManager authenticationManager){
       this.authenticationManager=authenticationManager;
   }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        AppUser appUser=null;
        try {
            appUser =new ObjectMapper().readValue(request.getInputStream(),AppUser.class);
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
        System.out.println("******************************");
        System.out.println("username "+appUser.getUsername());
        System.out.println("password "+appUser.getPassword());
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword()));
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        User springUser= (User) authResult.getPrincipal();
        String jwt = Jwts.builder()
                .setSubject(springUser.getUsername())
                .setExpiration(new Date(System.currentTimeMillis()+SecurityConstantes.EXPIRATE_TIME))
                .signWith(SignatureAlgorithm.HS256,SecurityConstantes.SECRET)
                .claim("roles", springUser.getAuthorities())
                .compact();
        response.addHeader(SecurityConstantes.HEADER_STRING,SecurityConstantes.TOKEN_PREFIX+jwt);

    }
}
