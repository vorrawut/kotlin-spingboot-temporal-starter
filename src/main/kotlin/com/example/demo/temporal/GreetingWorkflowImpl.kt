package com.example.demo.temporal

import io.temporal.activity.ActivityOptions
import io.temporal.workflow.Workflow
import java.time.Duration

class GreetingWorkflowImpl : GreetingWorkflow {
    private val activityOptions = ActivityOptions.newBuilder()
        .setStartToCloseTimeout(Duration.ofSeconds(10))  // Set a timeout for the activity
        .build()

    private val activity = Workflow.newActivityStub(GreetingActivity::class.java, activityOptions)

    override fun getGreeting(name: String): String {
        return activity.createGreeting(name)
    }
}
