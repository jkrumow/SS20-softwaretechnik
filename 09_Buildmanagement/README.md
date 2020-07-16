# Buildmanagement

Contains an Ant script which builds and processes a simple Java project.

Script can be executed on the command line. 

Prerequisites: JAVA_HOME and ANT_HOME must be set.

Tasks:

- get: fetches necessary dependencies for testing
- clean: removes all artifacts
- compile: builds the application and test
- jar: creates a jar from all class files
- run: executes the application
- test: executes the test
- doc: creates JavaDoc
