package com.mercury.final_server.security;


import com.mercury.final_server.security.handler.*;
import com.mercury.final_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import com.mercury.final_server.security.handler.AccessDeniedHandlerImpl;
import com.mercury.final_server.security.handler.AuthenticationEntryPointImpl;
import com.mercury.final_server.security.handler.AuthenticationFailureHandlerImpl;
import com.mercury.final_server.security.handler.AuthenticationSuccessHandlerImpl;
import com.mercury.final_server.security.handler.LogoutSuccessHandlerImpl;

import java.util.Arrays;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;
    @Autowired
    AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;
    @Autowired
    AuthenticationEntryPointImpl authenticationEntryPointImpl;
    @Autowired
    AccessDeniedHandlerImpl accessDeniedHandlerImpl;
    @Autowired
    LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;

//    @Autowired
//    public void setup(AuthenticationManagerBuilder builder) throws Exception {
//        // setup will be automatically invoked after AuthenticationManagerBuilder is injected
//        builder.userDetailsService(userService).passwordEncoder(passwordEncoder);
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.csrf().disable();
//
//        http.formLogin()
//                .loginProcessingUrl("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .successHandler(authenticationSuccessHandler)
//                .failureHandler(authenticationFailureHandler);
//
//        http.exceptionHandling()
//                .authenticationEntryPoint(authenticationEntryPointImpl);
//
//
//        http.exceptionHandling()
//                .accessDeniedHandler(accessDeniedHandlerImpl);
//
//
//        http.logout()
//                .logoutUrl("/logout")
//                .logoutSuccessHandler(logoutSuccessHandlerImpl);
//
//
//        http.rememberMe()
//                .rememberMeParameter("remember-me")
//                .tokenValiditySeconds(14 * 24 * 60 * 60);
//
//        http.cors();
        http.csrf().disable()
                .cors() // cors config.
                .and()
                .authorizeRequests()
                .antMatchers("/index.html", "/menu", "/menu/*").permitAll()
//                .antMatchers("/index.html", "/products", "/products/*").permitAll()
//                .antMatchers("/orders", "/orders/*").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/users", "/users/*").hasAnyRole("ADMIN")
                .and()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPointImpl)
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandlerImpl)
                .and()
                .formLogin()
                .permitAll()
                .loginProcessingUrl("/login")
                .successHandler(authenticationSuccessHandlerImpl)
                .failureHandler(authenticationFailureHandlerImpl)
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccessHandlerImpl)
                .and()
                .rememberMe();

    }

    /*
     * cors support
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
//      configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.addAllowedOrigin("*"); // You should only set trusted site here. e.g. http://localhost:4200 means only this site can access.
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","HEAD","OPTIONS"));
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
