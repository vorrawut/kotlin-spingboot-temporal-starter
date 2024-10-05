package com.example.demo.config

import com.example.demo.temporal.GreetingActivityImpl
import com.example.demo.temporal.GreetingWorkflowImpl
import io.temporal.client.WorkflowClient
import io.temporal.worker.WorkerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.slf4j.LoggerFactory

@Configuration
class TemporalWorkerConfig(private val workflowClient: WorkflowClient) {

    private val logger = LoggerFactory.getLogger(TemporalWorkerConfig::class.java)

    @Bean
    fun startWorkers(): WorkerFactory {
        val factory = WorkerFactory.newInstance(workflowClient)
        val worker = factory.newWorker("GreetingTaskQueue")

        worker.registerWorkflowImplementationTypes(GreetingWorkflowImpl::class.java)
        worker.registerActivitiesImplementations(GreetingActivityImpl())

        // Retry mechanism to ensure Temporal is up before starting the workers
        retryUntilConnected(factory)

        factory.start()
        return factory
    }

    private fun retryUntilConnected(factory: WorkerFactory) {
        var retries = 0
        while (true) {
            try {
                factory.start()  // Attempt to start the factory
                logger.info("Successfully connected to Temporal after $retries retries")
                break
            } catch (ex: Exception) {
                retries++
                logger.error("Failed to connect to Temporal. Retrying... ($retries)")
                Thread.sleep(5000)  // Wait for 5 seconds before retrying
            }
        }
    }
}
