package com.example.demo.config

import io.temporal.client.WorkflowClient
import io.temporal.client.WorkflowClientOptions
import io.temporal.serviceclient.WorkflowServiceStubs
import io.temporal.serviceclient.WorkflowServiceStubsOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TemporalClientConfig {

    @Bean
    fun workflowClient(): WorkflowClient {
        val serviceStubsOptions = WorkflowServiceStubsOptions.newBuilder()
            .setTarget("localhost:7233")
            .build()

        val service = WorkflowServiceStubs.newInstance(serviceStubsOptions)
        return WorkflowClient.newInstance(service)
    }
}
