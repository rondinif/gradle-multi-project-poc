# A Gradle Multi Project Proof Of Concept
a POC for a possible answer to the question [Gradle and Spring-bootRun can not find my class](https://stackoverflow.com/questions/62213471/gradle-and-spring-bootrun-can-not-find-my-class)
by leveraging [multi project builds](https://docs.gradle.org/current/userguide/multi_project_builds.html)

## other solutions
`master` implements **multi project builds** look also at other branches of the project where other solutions are implemented:
- [`limited-commit-to-advanced`](https://github.com/rondinif/gradle-multi-project-poc/tree/limited-commit-to-advanced)
- [`composite-build`](https://github.com/rondinif/gradle-multi-project-poc/tree/composite-build) based on [Mehmet Sunkur's answer](https://stackoverflow.com/a/62333926/1657028)


#### This POC use java 1.8 
``` zsh 
$ export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
```
## how to 
``` zsh
$ git clone https://github.com/rondinif/gradle-multi-project-poc
$ cd gradle-multi-project-poc
$ gradle classic:build
$ gradle advanced:build
# gradle classic:run
$ gradle advanced:bootRun
```
Note all the above commands are issued from the root project, no `cd` in `Classic` or `Advanced` is required.   

#### a note about the Classic project
in this poc the Classic project actually is not a spring-boot application because of, 
for the sake of the question, it has only to provide a `foo.Classic` classic to the Advanced project that can load the `foo.Bar` from the `Advanced` project by using `Class.forName` 
```
$ git clone https://github.com/rondinif/gradle-multi-project-poc
$ cd gradle-multi-project-poc
$ gradle Classic:run
# OK
```

The final results should not change if also the `Classic` project is a spring-boot application,
bun in in this case we'll use `gradle Classic:bootRun`


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
- [Mehmet Sunkur's answer](https://stackoverflow.com/a/62333926/1657028)
- https://docs.gradle.org/current/userguide/composite_builds.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-devtools

# Licence
MIT