package com.hendisantika.springbootkotlinsample.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/06/18
 * Time: 08.52
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebSecurity
class WebSecurityConfig(val userDetailsService: UserDetailsService) {

    @Throws(Exception::class)

//    override fun configure(auth: AuthenticationManagerBuilder) {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder())
//        val encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
//        auth.inMemoryAuthentication()
//                .withUser("naruto")
//                .password(encoder.encode("naruto"))
//                .roles("USER")
//    }
//    @Bean
//    fun authenticationManager(
//        authBuilder: AuthenticationManagerBuilder
//    ): AuthenticationManager {
//        val passwordEncoder = passwordEncoder()
//
//        // Configure in-memory user
//        authBuilder
//            .inMemoryAuthentication()
//            .withUser("naruto")
//            .password(passwordEncoder.encode("naruto"))
//            .roles("USER")
//
//        // Add custom DaoAuthenticationProvider (if needed)
//        authBuilder.authenticationProvider(daoAuthenticationProvider())
//
//        return authBuilder.build()
//    }
//
//    @Bean
//    fun daoAuthenticationProvider(): DaoAuthenticationProvider {
//        val provider = DaoAuthenticationProvider()
//        provider.setUserDetailsService(userDetailsService)
//        provider.setPasswordEncoder(passwordEncoder())
//        return provider
//    }

//    @Bean
//    fun inMemoryUserDetailsManager(): InMemoryUserDetailsManager {
//        val user: UserDetails = User.withUsername("naruto")
//            .password(passwordEncoder().encode("naruto"))
//            .roles("USER")
//            .build()
//        return InMemoryUserDetailsManager(user)
//    }

    @Bean
    fun inMemoryUserDetailsManager(): InMemoryUserDetailsManager {
        val user: UserDetails = User.withUsername("naruto")
            .password(passwordEncoder().encode("naruto"))
            .roles("USER")
            .build()
        return InMemoryUserDetailsManager(user)
    }

    @Bean
    fun daoAuthenticationProvider(): DaoAuthenticationProvider {
        val provider = DaoAuthenticationProvider()
        provider.setUserDetailsService(inMemoryUserDetailsManager())
        provider.setPasswordEncoder(passwordEncoder())
        return provider
    }

    @Bean
    fun authenticationManager(
        authenticationConfiguration: AuthenticationConfiguration
    ): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests {
                it
                    .requestMatchers("/js/**", "/css/**", "/img/**", "/webjars/**", "/resources/**", "/login")
                    .permitAll()
            }
            .formLogin { formLogin ->
                formLogin
                .loginPage("/login")
                    .defaultSuccessUrl("/message").permitAll()
            }
            .logout { logout -> logout.permitAll() }

//        http.authorizeRequests()
//                .antMatchers("/login").anonymous()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/login.html")
//                .failureUrl("/login?error")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/message.html", true)
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login?logout")
//
//        http.exceptionHandling().accessDeniedPage("/message.html")
//        http.sessionManagement().invalidSessionUrl("/login")
        return http.build()
    }


    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }
}
