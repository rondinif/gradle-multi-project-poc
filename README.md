# A Gradle Multi Project Proof Of Concept
a POC for a possible answer to the question [Gradle and Spring-bootRun can not find my class](https://stackoverflow.com/questions/62213471/gradle-and-spring-bootrun-can-not-find-my-class)
by leveraging [multi project builds](https://docs.gradle.org/current/userguide/multi_project_builds.html)

### limited-commit-to-advanced use case

the current **limited-commit-to-advanced** branch 
adapts the answer to [EDITs](https://stackoverflow.com/posts/62213471/revisions) 
made to the [question](https://stackoverflow.com/questions/62213471/gradle-and-spring-bootrun-can-not-find-my-class/62293125#62293125)
in particular referring to the aspect that **commits can only be made to Advanced**

##### about the reference to the Classic project from the Advanced build.gradle
according to the [documentation](https://docs.gradle.org/5.2.1/userguide/dependency_types.html#sub:file_dependencies) 
since the user expressed the need that **commits can only be made to Advanced** the `Classic` project should be referenced as *dependecy* in the `Advanced` project by a **file dependency** or another [type of dependecy](https://docs.gradle.org/5.2.1/userguide/dependency_types.html) available for the user's development environment .

![example of change to the the Advanced/build.gradle to support the new requirement](advanced-deps-change.png)
<!-- on branch master ther Classic project was named Basic -->


#### This POC use java 1.8 
``` zsh 
$ export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
```
## how to
``` zsh
$ git clone https://github.com/rondinif/gradle-multi-project-poc
$ cd gradle-multi-project-poc
$ gradle classic:build
# the above command can be changed as you wish as long as the Classic project is built
$ cd Advanced
$ gradle bootRun
```

#### a note about the Classic project
in this poc the Classic project actually is not a spring-boot application because of, 
for the sake of the question, it has only to provide a `foo.Classic` classic to the Advanced project that can load the `foo.Bar` from the `Advanced` project by using `Class.forName` 
``` zsh
[gradle-multi-project-poc (limited-commit-to-advanced)]$ gradle Classic:build
BUILD SUCCESSFUL in 1s
7 actionable tasks: 7 executed
[gradle-multi-project-poc (limited-commit-to-advanced)]$ ls -lart Classic/build/libs/               
total 8
drwxr-xr-x   3 ronda  staff    96 Jun 10 13:20 .
-rw-r--r--   1 ronda  staff  1363 Jun 10 13:20 Classic-0.0.1-SNAPSHOT.jar
drwxr-xr-x  10 ronda  staff   320 Jun 10 13:20 ..
[gradle-multi-project-poc (limited-commit-to-advanced)]$   
```

The final results should not change if also the `Classic` project is a spring-boot application.


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
- https://docs.gradle.org/5.2.1/userguide/dependency_types.html#sub:file_dependencies
- https://docs.gradle.org/current/userguide/multi_project_builds.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-devtools

# Licence
MIT