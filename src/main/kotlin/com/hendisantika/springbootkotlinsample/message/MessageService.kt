package com.hendisantika.springbootkotlinsample.message

import com.hendisantika.springbootkotlinsample.account.Account
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/06/18
 * Time: 22.04
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
class MessageService(val messageRepository: MessageRepository) {

    @Transactional(readOnly = true)
    fun findAll(): List<Message> {
        return messageRepository.findAll()
    }

    fun save(messageForm: MessageForm, account: Account?): Message {
        return messageRepository.save(Message(messageForm.message, account))
    }

    @Transactional(readOnly = true)
    fun findByAccount(account: Account?): List<Message> {
        return messageRepository.findByAccount(account)
    }

    fun delete(id: Message) {
        messageRepository.delete(id)
    }
}