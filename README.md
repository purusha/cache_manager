# Cache manager project

## Mandatory

Run .\scripts\environment.sh

## Build

mvn clean install

## Run

mvn spring-boot:run

## Api definition

http://localhost:8080/api

## Swagger

http://localhost:8080/swagger

## Api

### Get all users from database

[GET] http://localhost:8080/manager/users

### Get all users from cache

[GET] http://localhost:8080/manager/users/cached

### Put users on cache

[POST] http://localhost:8080/manager/users/cache

### Delete all users from cache

[DELETE] http://localhost:8080/manager/users/cached