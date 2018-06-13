package com.hendisantika.springbootkotlinsample.account

import com.hendisantika.springbootkotlinsample.NULL
import org.hibernate.validator.constraints.NotEmpty

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/06/18
 * Time: 08.47
 * To change this template use File | Settings | File Templates.
 */
data class AccountForm(@get:NotEmpty var name: String? = NULL,
                       var id: Long? = NULL)