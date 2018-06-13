package com.hendisantika.springbootkotlinsample.account

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 13/06/18
 * Time: 11.25
 * To change this template use File | Settings | File Templates.
 */
interface AccountRepository : JpaRepository<Account, Long> {
    fun findByname(name: String): Optional<Account>
}