package com.hendisantika.springbootkotlinsample.message

import com.hendisantika.springbootkotlinsample.account.Account
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/06/18
 * Time: 07.03
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/message")
class MessageController(val messageService: MessageService) {

    @ModelAttribute("messages")
    fun messages(@AuthenticationPrincipal account: Account?): List<Message> = messageService.findAll()

    @ModelAttribute
    fun account(@AuthenticationPrincipal account: Account?): Account? = account

    @GetMapping
    fun findAll(model: Model, @AuthenticationPrincipal account: Account?): String {
        return "message"
    }

    @PostMapping
    fun save(@Valid @ModelAttribute messageForm: MessageForm, bindingResult: BindingResult, @AuthenticationPrincipal account: Account?): String {
        if (bindingResult.hasErrors()) {
            return "message"
        }
        messageService.save(messageForm, account)
        return "redirect:/message"
    }

    @GetMapping("/delete/{id}")
    fun delete(@PathVariable id: Message): String {
        messageService.delete(id)
        return "redirect:/message"
    }
}