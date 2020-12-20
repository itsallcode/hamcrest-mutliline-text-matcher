# hamcrest-multiline-text-matcher 2.0.0, released 2020-12-20

Codename: Update Frenzy

## Summary 

In version 2.0.0 we ported all tests from JUnit 4 to JUnit 5. We also updated all other dependencies.

Updated formatter settings.

Breaking change: requires Java 11 instead of Java 8.

## Bug Fixes
 
* #2: Replaced Unit dependency that had a security issue

## Dependency updates
 
* Removed `org.junit:junit`
* Added `org.junit.jupiter:junit-jupiter-engine:5.6.2`

## Plug-in updates

* Added `org.apache.maven.plugins:maven-enforcer-plugin:3.0.0-M3`
* Added `org.codehaus.mojo:versions-maven-plugin:2.7`
* Added `org.sonatype.ossindex.maven:ossindex-maven-plugin:3.1.0`
* Updated `maven-compiler-plugin:3.7.0` to `3.8.1`
* Updated `maven-jar-plugin.3.1.0` to `3.2.0`
* Updated `maven-javadoc-plugin.3.0.1` to `3.2.0`
* Updated `maven-source-plugin.3.0.1` to `3.2.1`
* Updated `maven-surefire-plugin.2.21.0` to `3.0.0-M5` 
* Updated `org.codehaus.mojo:license-maven-plugin.1.16` to `1.20`
* Updated `org.jacoco:jacoco-maven-plugin.0.8.1` to `0.8.6`