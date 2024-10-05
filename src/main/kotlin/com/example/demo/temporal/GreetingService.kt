package com.example.demo.temporal

import io.temporal.client.WorkflowClient
import io.temporal.client.WorkflowOptions
import org.springframework.stereotype.Service

@Service
class GreetingService(private val workflowClient: WorkflowClient) {

    fun getGreeting(name: String): String {
        val options = WorkflowOptions.newBuilder()
            .setTaskQueue("GreetingTaskQueue")
            .build()

        val workflow = workflowClient.newWorkflowStub(GreetingWorkflow::class.java, options)
        return workflow.getGreeting(name)
    }
}
