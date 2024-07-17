# User_service
Source code for user-management , Implementation of CRUD,Kafka and Spring Security

#Docker-compose.ymml
version: '3.8'

services:
  user-service:
    image: user-service:latest
    build:
      context: ./user-service
      dockerfile: Dockerfile
    depends_on:
      - user-db
    ports:
      - "8081:8080"

  journal-service:
    image: journal-service:latest
    build:
      context: ./journal-service
      dockerfile: Dockerfile
    depends_on:
      - journal-db
    ports:
      - "8082:8080"

volumes:
  user-db-data:
  journal-db-data:

#Command to run the docker-compose file
docker-compose up --build
