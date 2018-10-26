# Weather Log API: Lyndon Bibera
Machine problem exercise for my job application on [HomeCredit PH](https://www.homecredit.ph/my-home-credit-app/)

## Features
Here are the two features I gathered from the documentation

#### API-1: Display Weather Information
- [x] API-1: list of weather from London, Prague, and San Francisco
- [x] include location, actual weather, temperature
- [x] JSON format

#### API-2: Store Responses
- [x] store last 5 unique responses from API-1 in a buffer
- [x] save in a DB table "WeatherLog" when API-2 is triggered
- [x] generate "responseId" after creating the response
- [x] generate "dTimeInserted" after saving the data
- [x] generate "id" after saving the data

## Developer Notes
The project template was generated from the [Spring Initializer](https://start.spring.io/) using Gradle and the latest release candidate for Spring Boot.

#### Requirements
- Java
- Setup the environment variables refer to the [application.yaml](src/main/resources/application.yaml) for config details

#### Running the App
- use the gradle wrapper
```
cd weather-info-api
./gradlew bootRun
```
- test
```
./gradlew test
```

#### Building the App
```
./gradlew build -x test

java -jar build/libs/weather-log-api-0.0.1-SNAPSHOT.jar \
--ph.homecredit.weatherlog.api.weatherMapAPIKey=xxx-insert-api-key-here-xxx \
--spring.datasource.url=jdbc:postgresql://xxx-insert-db-endpoint-here-xxx.us-west-2.rds.amazonaws.com:5432/homecredit \
--spring.datasource.username=xxx-insert-username-here-xxx \
--spring.datasource.password=xxx-insert-password-here-xxx
```

#### For IntelliJ Users
- you need to manually enable the annotation processors
![IntelliJ and Lombok](/docs/img/idea-lombok.png)