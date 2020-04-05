package com.hendisantika.springbootkotlinsample.account

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 13/06/18
 * Time: 11.27
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
class AccountService(val accountRepository: AccountRepository) {

    @Transactional(readOnly = true)
    fun findAll(): MutableList<Account> {
        return accountRepository.findAll()
    }

    fun save(accountForm: AccountForm): Account {
        return accountRepository.save(Account(accountForm.name))
    }
}