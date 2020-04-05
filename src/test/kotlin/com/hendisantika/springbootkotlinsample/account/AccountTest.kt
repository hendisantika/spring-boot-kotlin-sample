package com.hendisantika.springbootkotlinsample.account

import org.hamcrest.CoreMatchers
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit4.SpringRunner

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/18
 * Time: 18.37
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringRunner::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountTest {
    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var accountRepository: AccountRepository

    @Test
    fun newAccountHasNameAndPassword() {
        val account = Account("hendisantika", "pass123")
        val saved = this.accountRepository.save(account)
        assertThat(saved.name, CoreMatchers.`is`("hendisantika"))
        assertThat(saved.passwd, CoreMatchers.`is`("pass123"))
    }
}