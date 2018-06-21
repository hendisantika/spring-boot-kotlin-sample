package com.hendisantika.springbootkotlinsample.account

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/18
 * Time: 18.25
 * To change this template use File | Settings | File Templates.
 */

@RunWith(MockitoJUnitRunner::class)
class AccountServiceTest {
    @Mock
    lateinit var accountRepository: AccountRepository

    lateinit var accountService: AccountService

    @Before
    fun setup() {
        accountService = AccountService(accountRepository)
    }


    @Test
    fun findAll() {
        val accounts = listOf(Account("hendisantika", "123123"), Account("naruto", "pass"))
        given(accountRepository.findAll()).willReturn(accounts)
        val findAccounts = accountService.findAll()
        assertThat(findAccounts[0].name, `is`("hendisantika"))
        assertThat(findAccounts[1].name, `is`("naruto"))
        assertThat(findAccounts[0].passwd, `is`("123123"))
        assertThat(findAccounts[1].passwd, `is`("pass"))
    }

    @Test
    fun save() {
        val account = Account("hendisantika")
        val accountForm = AccountForm("hendisantika")
        given(accountRepository.save(account)).willReturn(account)
        val saveAccount = accountService.save(accountForm)
        assertThat(saveAccount.name, `is`("hendisantika"))
    }
}