package com.example.demo.temporal

import io.temporal.activity.ActivityInterface
import io.temporal.activity.ActivityMethod

@ActivityInterface
interface GreetingActivity {
    @ActivityMethod
    fun createGreeting(name: String): String
}
