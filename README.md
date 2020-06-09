# A Gradle Multi Project Proof Of Concept
a POC for a possible answer to the question [Gradle and Spring-bootRun can not find my class](https://stackoverflow.com/questions/62213471/gradle-and-spring-bootrun-can-not-find-my-class)
by leveraging [multi project builds](https://docs.gradle.org/current/userguide/multi_project_builds.html)

#### This POC use java 1.8 
``` zsh 
$ export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
```
## how to 
``` zsh
$ git clone https://github.com/rondinif/gradle-multi-project-poc
$ cd gradle-multi-project-poc
$ gradle basic:build
$ gradle advanced:build
# gradle basic:run
$ gradle advanced:bootRun
```
Note al the above commands are issued from the root project, no `cd` in `Basic` or `Advanced` is required.   

#### a note about the Basic project
in this poc the Basic project actually is not a spring-boot application because of, 
for the sake of the question, it has only to provide a `foo.Classic` classic to the Advanced project that can load the `foo.Bar` from the `Advanced` project by using `Class.forName` 
```
$ git clone https://github.com/rondinif/gradle-multi-project-poc
$ cd gradle-multi-project-poc
$ gradle Basic:run
# OK
```

The final results should not change if also the `Basic` project is a spring-boot application,
bun in in this case we'll use `gradle Basic:bootRun`


## additional information about the testing/development environment
```
[62213471 (master)]$ gradle -version

------------------------------------------------------------
Gradle 6.5
------------------------------------------------------------

Build time:   2020-06-02 20:46:21 UTC
Revision:     a27f41e4ae5e8a41ab9b19f8dd6d86d7b384dad4

Kotlin:       1.3.72
Groovy:       2.5.11
Ant:          Apache Ant(TM) version 1.10.7 compiled on September 1 2019
JVM:          1.8.0_242 (AdoptOpenJDK 25.242-b08)
OS:           Mac OS X 10.15.5 x86_64
```

## references used
- https://docs.gradle.org/current/userguide/multi_project_builds.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-devtools

# Licence
MIT