package com.example.demo.temporal

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController(private val greetingService: GreetingService) {

    @GetMapping("/greet")
    fun greet(@RequestParam name: String): String {
        return greetingService.getGreeting(name)
    }
}
