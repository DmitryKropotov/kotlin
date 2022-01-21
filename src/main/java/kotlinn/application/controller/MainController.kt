package kotlinn.application.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {
    @GetMapping
    fun index(): List<Message> = listOf(
        Message("1", "Hello!"),
        Message("2", "Bonjour!"),
        Message("3", "Privet!")
    )

    @GetMapping("/printMessage")
    fun printMessage(): String {
        println("ok")
        return "Hello, world"
    }
}

data class Message(val id: String, val text: String)