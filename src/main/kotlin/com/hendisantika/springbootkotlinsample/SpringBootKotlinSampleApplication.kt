package com.hendisantika.springbootkotlinsample

//import org.springframework.boot.runApplication
import com.hendisantika.springbootkotlinsample.account.Account
import com.hendisantika.springbootkotlinsample.account.AccountRepository
import com.hendisantika.springbootkotlinsample.message.Message
import com.hendisantika.springbootkotlinsample.message.MessageRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.stream.Stream


val NULL = null

@SpringBootApplication
class SpringBootKotlinSampleApplication constructor(val accountRepository: AccountRepository, val messageRepository: MessageRepository) : CommandLineRunner {
    override fun run(vararg p0: String?) {
        val encoder = BCryptPasswordEncoder(16)
        accountRepository.deleteAll()
        Stream.of("naruto,123", "user,456", "sasuke,212", "hendisantika,234")
                .map { account -> account.split(",") }
                .forEach { name ->
                    val save = Account(name[0], encoder.encode(name[1]))
                    println(save)
                    accountRepository.save(save)
                    Stream.of("hi", "hendi", "hello")
                            .forEach { message -> messageRepository.save(Message(message, save)) }
                }
    }

}

fun main(args: Array<String>) {
//    runApplication<SpringBootKotlinSampleApplication>(*args)
    SpringApplication.run(SpringBootKotlinSampleApplication::class.java, *args)
}

@Bean
fun passwordEncoder(): PasswordEncoder {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder()
}



