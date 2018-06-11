package com.hendisantika.springbootkotlinsample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinSampleApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinSampleApplication>(*args)
}
