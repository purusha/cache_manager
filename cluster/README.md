# Cache manager project


## Build

mvn clean package spring-boot:repackage

## Run Environment

Run .\scripts\environment.sh


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