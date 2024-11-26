package com.hendisantika.springbootkotlinsample.account

import com.hendisantika.springbootkotlinsample.NULL
import com.hendisantika.springbootkotlinsample.message.Message
import jakarta.persistence.*
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/06/18
 * Time: 08.38
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Access(AccessType.FIELD)
data class Account(

        @get:NotEmpty
        var name: String? = NULL,

        @get:NotEmpty
        var passwd: String? = NULL,

        @OneToMany(mappedBy = "account")
        var messages: List<Message>? = NULL,

        @Id @GeneratedValue
        var id: Long? = NULL
) : UserDetails {
    override fun getUsername(): String = name!!

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    fun authorities(account: Account): MutableCollection<out GrantedAuthority> {
        val authorities = mutableListOf<GrantedAuthority>()
        authorities.add(SimpleGrantedAuthority("ROLE_USER"))
        if (account.name.equals("naruto")) authorities.add(SimpleGrantedAuthority("ROLE_ADMIN"))
        return authorities
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? = authorities(this)
    override fun isEnabled(): Boolean = true

    override fun getPassword(): String = passwd!!
}
