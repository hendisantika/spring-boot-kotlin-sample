package com.hendisantika.springbootkotlinsample.message

import com.hendisantika.springbootkotlinsample.NULL

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/06/18
 * Time: 08.16
 * To change this template use File | Settings | File Templates.
 */
data class MessageForm(
        @get:org.hibernate.validator.constraints.NotEmpty var message: String? = NULL
)