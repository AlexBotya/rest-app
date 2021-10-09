package ru.gb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMIN_LOGIN = "Admin";
    private static final String ADMIN_PASSWORD = "password";

    private static final String USER_LOGIN = "User";
    private static final String USER_PASSWORD = "password";

    enum Role {
        USER, ADMIN
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(
                        userBuilder.username(ADMIN_LOGIN)
                                .password(ADMIN_PASSWORD)
                                .roles(Role.USER.name(), Role.ADMIN.name())
                )
                .withUser(
                        userBuilder.username(USER_LOGIN)
                                .password(USER_PASSWORD)
                                .roles(Role.USER.name())
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole(Role.USER.name())
                .antMatchers("/categories/**").hasRole(Role.ADMIN.name())
                .and()
                .formLogin();
    }

}