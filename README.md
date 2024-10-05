
# Temporal Starter Project

A **starter project** demonstrating how to integrate **Temporal** with **Spring Boot**. This project includes examples of workflows, activities, and a Docker-based setup with **PostgreSQL** and **Temporal UI** to manage and monitor workflow executions.

## Features

- **Spring Boot Integration**: Example workflows and activities.
- **Temporal UI**: Pre-configured UI to visualize and manage workflows.
- **PostgreSQL Persistence**: Uses PostgreSQL to store Temporal’s state.
- **Docker Compose Setup**: Quickly spin up Temporal, PostgreSQL, and the UI for local development.

## Getting Started

### Prerequisites

- **Docker** and **Docker Compose** installed on your machine.
- **JDK 21** installed for running the Spring Boot application.

### Setup and Run Temporal

1. **Clone the repository**:


2. **Start Temporal, PostgreSQL, and Temporal UI** using Docker Compose:

   ```bash
   docker-compose up --build
   ```

3. **Run the Spring Boot application**:

   ```bash
   ./gradlew bootRun
   ```

4. **Access the Temporal UI** to monitor workflows:

   Open your browser and navigate to `http://localhost:8088`.

## Project Structure

- **src/main/java/com/example/demo**: Contains the workflow and activity interfaces and implementations.
- **TemporalWorkerConfig**: Registers workflows and activities with Temporal.
- **Docker Compose**: Sets up Temporal, PostgreSQL, and Temporal UI.

## Workflow Example

The project includes a simple **Greeting Workflow**:

1. The workflow takes a name as input.
2. An activity generates a greeting message.
3. The result is returned and can be viewed in the logs or Temporal UI.

## License

This project is licensed under the MIT License.
