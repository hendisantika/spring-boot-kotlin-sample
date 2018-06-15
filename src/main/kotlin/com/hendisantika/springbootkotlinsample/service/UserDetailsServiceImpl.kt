package com.hendisantika.springbootkotlinsample.service

import com.hendisantika.springbootkotlinsample.account.AccountRepository
import com.hendisantika.springbootkotlinsample.account.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/06/18
 * Time: 08.15
 * To change this template use File | Settings | File Templates.
 */
@Service
class UserDetailsServiceImpl(val accountRepository: AccountRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val account = accountRepository.findByname(username)
        return account.orElseThrow { UserNotFoundException("not found user name : $username ") }
    }
}