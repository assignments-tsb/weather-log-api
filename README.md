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
- [ ] save in a DB table "WeatherLog" when API-2 is triggered
- [x] generate "responseId" after creating the response
- [ ] generate "dTimeInserted" after saving the data
- [ ] generate "id" after saving the data

## Developer Notes
The project template was generated from the [Spring Initializer](https://start.spring.io/) using Gradle and the latest release candidate for Spring Boot.

#### Requirements
- Java

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

#### For IntelliJ Users
- you need to manually enable the annotation processors
![IntelliJ and Lombok](/docs/img/idea-lombok.png)