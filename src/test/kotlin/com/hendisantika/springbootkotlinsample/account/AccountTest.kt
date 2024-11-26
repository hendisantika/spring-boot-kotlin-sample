package com.hendisantika.springbootkotlinsample.account

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

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
