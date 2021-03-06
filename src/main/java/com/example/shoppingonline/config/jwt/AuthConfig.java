package com.example.shoppingonline.config.jwt;



import com.example.shoppingonline.service.jwt.JwtUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private JwtUserDetailsService jwtUserDetailsService;
//    @Autowired
//    private JwtRequestFilter jwtRequestFilter;

    private final JwtUserDetailService userDetailService;

    private final JwtRequestFilter jwtRequestFilter;

    public AuthConfig(JwtUserDetailService userDetailService, JwtRequestFilter jwtRequestFilter) {
        this.userDetailService = userDetailService;
        this.jwtRequestFilter = jwtRequestFilter;
    }
    /*JWT step*/


    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    /*Authentication STEP*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /* change to userDetailsService */
        auth.userDetailsService(userDetailService);
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("admin")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("admin")
//                .roles("USER","ADMIN");
    }

    /*Authorization STEP*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/address/**").permitAll()
                .antMatchers("/users").permitAll()
                .antMatchers("/category").permitAll()
                .antMatchers("/subcategory").permitAll()
                .antMatchers("/images").permitAll()
                .antMatchers("/orderdetail").permitAll()
                .antMatchers("/order").permitAll()
                .antMatchers("/product").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
//                .and().httpBasic();
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }//Authorization


    /*Authentication STEP*/

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


}
