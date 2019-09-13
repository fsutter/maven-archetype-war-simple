# Project Name
> Simple maven archetype for creating a web application.

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Usage](#usage)
* [Features](#features)
* [Status](#status)
* [Inspiration](#inspiration)
* [Contact](#contact)

## General info
Add more general information about project. What the purpose of the project is? Motivation?

## Technologies
* Jersey - version 2.29.1
* Swagger Jersey2 JAXRS - version 1.5.23
* Swagger UI - version 3.23.8
* SnakeYAML - version 1.25
* CORS filter - version 2.8
* Jasypt - version 1.9.3

## Setup
mvn install

## Usage
* Eclipse/IntelliJ IDEA: use your favorite IDE to create a new Maven project with **ws.sutter.archetypes** as *Group Id* and **maven-archetype-war-simple** as *Artifact Id*.
* Manually:
  
  ```
  mvn archetype:generate\
    -DgroupId=[your project's group id]\
    -DartifactId=[your project's artifact id]\
    -DarchetypeGroupId=ws.sutter.archetypes\
    -DarchetypeArtifactId=maven-archetype-war-simple
  ```

## Features
List of features ready and TODOs for future development
* Awesome feature 1
* Awesome feature 2
* Awesome feature 3

To-do list:
* Wow improvement to be done 1
* Wow improvement to be done 2

## Status
Project is: _in progress_

## Inspiration
This project is inspired by [Guide to Creating Archetypes](https://maven.apache.org/guides/mini/guide-creating-archetypes.html) from Apache.

## Contact
Created by [@fsutter](https://www.sutter.me/) - feel free to contact me!
