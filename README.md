
# Hoen Scanner Microservice

## Overview

The **Hoen Scanner** is a microservice that provides an API for searching rental cars and hotels in the Hoen Archipelago. Built using the **Dropwizard** framework, it allows users to submit a city name and retrieve matching results from predefined JSON data.

## Setup & Run

### 1. Build the Project

To build the project, run the following command:

`mvn clean package`

This will clean and build the project, creating a `hoen-scanner-1.0-SNAPSHOT.jar` file in the `target` directory.

### 2. Run the Microservice

Once the project is built, you can run the microservice using the following command:

`java -jar target/hoen-scanner-1.0-SNAPSHOT.jar server src/main/resources/config.yml`

This will start the server, and the microservice will be available on `http://localhost:8080`.


## Test the Microservice

### Using PowerShell (Invoke-WebRequest)

To test the search functionality, use the following PowerShell command to send a POST request to the `/search` endpoint:

`Invoke-WebRequest -Uri http://localhost:8080/search -Method POST -Headers @{ "Content-Type" = "application/json" } -Body '{"city":"Petalborough"}'`

### Expected Response

The response should return a JSON array with matching results for hotels and rental cars in the city of Petalborough
