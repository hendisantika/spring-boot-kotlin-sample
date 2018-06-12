package com.hendisantika.springbootkotlinsample.message

import com.hendisantika.springbootkotlinsample.NULL
import com.hendisantika.springbootkotlinsample.account.Account
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.validation.constraints.NotEmpty

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/06/18
 * Time: 08.58
 * To change this template use File | Settings | File Templates.
 */
@Entity
data class Message(
        @get:NotEmpty var message: String? = NULL,

        @ManyToOne(fetch = javax.persistence.FetchType.LAZY)
        var account: Account? = NULL,

        @Id @GeneratedValue var id: Long? = NULL
)