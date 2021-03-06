[![Build Status](https://travis-ci.org/oregami/dropwizard-guice-jpa-seed.png)](https://travis-ci.org/oregami/dropwizard-guice-jpa-seed)

dropwizard-guice-jpa-seed
=========================
This a sample REST application written in Java. It's purpose is to create a generic project that can be used as a starting point for a new project, but also for learning efforts (I am building an open game database at www.oregami.org).

- built on [Dropwizard](https://dropwizard.github.io/dropwizard/) version 0.7.0
- dependency injection with [Google Guice](https://code.google.com/p/google-guice/)
- [Hibernate](http://hibernate.org/) / JPA 2.1 as database access framework
- [HSQLDB](http://hsqldb.org/) as database
- "Session-per-HTTP-request" with Guice [PersistentFilter](https://code.google.com/p/google-guice/wiki/JPA)
- suport for [cross-origin resource sharing](http://en.wikipedia.org/wiki/Cross-origin_resource_sharing)
- JPA entities with [UUIDs](http://en.wikipedia.org/wiki/Universally_Unique_Identifier) as primary keys
- Basic authentication for DELETE at /task ("user" + "password")
- Integration tests with [rest-assured](https://code.google.com/p/rest-assured/)
- a pattern for accessing and manipulation entities with HTTP REST calls (Resource => Service => DAO => entity)
- a pattern for ServiceResult objects which contain ServiceErrorMessages (which can later be bound to web form fields in the client)

**Feel free to suggest corrections, optimizations or extensions via pull requests!**

# road map / things to do

* versioning/auditing of entities with [hibernate envers](http://envers.jboss.org/)
* hypermedia / HATEOAS


# Usage

* Start the application with the class "ToDoApplication" with the parameters "server todo.yml".

* List all tasks with:

        GET => http://localhost:8080/task

* Add a new task with:

        POST => http://localhost:8080/task

    Header:

        Content-Type:application/json

    JSON-Body e.g. :

        {"name" : "task 1", "description" : "This is a description"}

* Modify a task:

        PUT => http://localhost:8080/task/[id]

    Header:

        Content-Type:application/json
        Accept:application/json

    JSON-Body e.g.:

        {
        "id": "402880944687600101468760d9ea0000",
        "version": "0",
        "name": "task 1 with new name",
        "description": "This is an updated description",
        "finished": "false"
        }
        
* Remove a task: you must authenticate for this call with basic authentication (user = "user" and password="password")

        DELETE => http://localhost:8080/task/[id]
        
        

I recommend you use the great **chrome extension [Postman](http://getpostman.com)** to make such HTTP calls!
