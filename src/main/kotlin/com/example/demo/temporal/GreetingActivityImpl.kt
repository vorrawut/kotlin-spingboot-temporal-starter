package com.example.demo.temporal

class GreetingActivityImpl : GreetingActivity {
    override fun createGreeting(name: String): String {
        return "Hello, $name!"
    }
}
