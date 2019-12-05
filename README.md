# Background

The goal of this project is to convert a simple Java stopwatch to an
Android application.  The original java code can be found
[here](https://github.com/concurrency-cs-luc-edu/simplestopwatch-java).

# Learning Objectives

## Modeling

* Modeling state-dependent behavior with state machine diagrams
  (see also [here](/loyolachicagocs_comp313/stopwatch-android-java/src/default/doc))
* Distinguishing between view states and (behavioral) model states

## Semantics

* Event-driven/asynchronous program execution
* User-triggered input events
* Internal events from background timers
* Concurrency issues: single-thread rule of accessing/updating the view in the GUI thread

## Architecture and Design

* Key architectural issues and patterns
    * Simple dependency injection (DI)
    * Model-view-adapter (MVA) architectural pattern
    * Mapping MVA to Android
    * Difference between MVA and model-view-controller (MVC)
    * Distinguishing among dumb, reactive, and autonomous model components
* Key design patterns
    * Implementing event-driven behavior using the Observer pattern
    * Implementing state-dependent behavior using the State pattern
    * Command pattern for representing tasks as objects
    * Façade pattern for hiding complexity in the model from the adapter
* Relevant class-level design principles
    * Dependency Inversion Principle (DIP)
    * Single Responsibility Principle (SRP)
    * Interface Segregation Principle (ISP)
* Package-level architecture and relevant principles
    * Dependency graph
      (see also [here](/loyolachicagocs_comp313/stopwatch-android-java/src/default/doc))
    * Stable Dependencies Principle (SDP)
    * Acyclic Dependencies Principle (ADP)
* [Architectural journey](/stopwatch-android-java/commits)

## Testing

* Different types of testing
    * Component-level unit testing
    * System testing
    * Instrumentation testing
* Mock-based testing
* Testcase Superclass pattern (uses Template Method pattern)
* Test coverage

# Setting up the Environment

Check out the project using Android Studio. This creates the `local.properties` file
with the required line

    sdk.dir=<root folder of Android Studio's Android SDK installation>

# Running the Application

In Android Studio: `Run > Run app`

# Running the Tests

## Unit tests including out-of-emulator system tests using Robolectric

In Android Studio:

* Before running tests, in the *Android* view right-click on `edu.luc.etl.cs313...test (test)` - if `Select ...` is one
* of the visible menu items about 2/3 of the way down, click on that; if `Select ...` is not there, go to the next step
* Now click `Run > Edit Configurations...` and under `Android JUnit` click on `cs313 in app`
* On the *Configuration* tab, click the far-right icon in the *Working Directory* row and select `MODULE_DIR`, then click `OK`
* *If you do not do this, running the unit tests from the Android view will not work!*
* Finally, right-click on `edu.luc.etl.cs313...test (test)`, then choose `Run 'Tests in 'test''`

You can also use Gradle:

    $ ./gradlew testDebug # leave out the "./" on the Windows command line

You can view the resulting test reports in HTML by opening this file in your browser:

    app/build/reports/tests/testDebugUnitTest/index.html

## Unit test code coverage

In Gradle:

    $ ./gradlew jacocoTestDebugUnitTestReport # leave out "./" on the Windows command line

You can view the resulting test reports in HTML by opening this file in your browser:

    app/build/reports/jacoco/jacocoTestDebugUnitTestReport/html/index.html

## Android instrumentation tests (in-emulator/device system tests)

In Android Studio:

* In the *Android* view, right-click on `edu.luc.etl.cs313...android (androidTest)`, then choose `Run 'Tests in 'edu.luc.et...'`

You can also use Gradle:

    $ ./gradlew connectedDebugAndroidTest # leave out "./" on the Windows command line
