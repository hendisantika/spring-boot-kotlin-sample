package com.hendisantika.springbootkotlinsample.message

import com.hendisantika.springbootkotlinsample.account.Account
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 15/06/18
 * Time: 18.17
 * To change this template use File | Settings | File Templates.
 */
interface MessageRepository : JpaRepository<Message, Long> {
    fun findByAccount(account: Account?): List<Message>
}