# hamcrest-mutliline-text-matcher

This project provides a [Hamcrest](http://hamcrest.org/) matcher that gives you better diagnostics for multi-line text in case of mismatches.

[![Build Status](https://travis-ci.com/itsallcode/hamcrest-mutliline-text-matcher.svg?branch=master)](https://travis-ci.com/itsallcode/hamcrest-mutliline-text-matcher)
[![Download](https://api.bintray.com/packages/itsallcode/itsallcode/hamcrest-mutliline-text-matcher/images/download.svg) ](https://bintray.com/itsallcode/itsallcode/hamcrest-mutliline-text-matcher/_latestVersion)

## In a Nutshell

```java
import static org.itsallcode.matcher.MultilineTextMatcher.matchesAllLines;

public class TestSomeText {
	@Test
	public void testMatchesAllLines() {
		assertThat("foo\nbar", MultilineTextMatcher.matchesAllLines("foo", "bar"));
	}
}
```

## Features

This matcher provides the following features:

* Reports mismatches in the number of lines
* Marks where in the text a mismatch is found
* Makes invisible characters visible (CR, LF, TAB)

## Information for Developers

* [Developer Guide](doc/developer_guide/developer_guide.md)

## Dependencies

## Runtime Dependencies

The Hamcrest Multiline Text Matcher requires Java 11 to run.

## Test Dependencies

### Test Dependencies

| Dependency                                                                          | Purpose                                                | License                          |
|-------------------------------------------------------------------------------------|--------------------------------------------------------|----------------------------------|
| [Apache Maven](https://maven.apache.org/)                                           | Build tool                                             | Apache License 2.0               |
| [Java Hamcrest](http://hamcrest.org/JavaHamcrest/)                                  | Checking for conditions in code via matchers           | BSD License                      |
| [JUnit](https://junit.org/junit5)                                                   | Unit testing framework                                 | Eclipse Public License 1.0       |

### Maven Plug-ins

| Plug-in                                                                             | Purpose                                                | License                          |
|-------------------------------------------------------------------------------------|--------------------------------------------------------|----------------------------------|
| [License Maven Plugin](https://www.mojohaus.org/license-maven-plugin/)              | Adding license information to source files             | LGPL3                            |
| [Maven Compiler Plugin](https://maven.apache.org/plugins/maven-compiler-plugin/)    | Setting required Java version                          | Apache License 2.0               |
| [Maven Enforcer Plugin](http://maven.apache.org/enforcer/maven-enforcer-plugin/)    | Controlling environment constants                      | Apache License 2.0               |
| [Maven Failsafe Plugin](https://maven.apache.org/surefire/maven-surefire-plugin/)   | Integration testing                                    | Apache License 2.0               |
| [Maven Jacoco Plugin](https://www.eclemma.org/jacoco/trunk/doc/maven.html)          | Code coverage metering                                 | Eclipse Public License 2.0       |
| [Maven Javadoc Plugin](https://maven.apache.org/plugins/maven-javadoc-plugin)       | Create JAR archive with Javadoc                        | Apache License 2.0               |
| [Maven Source Plugin](http://maven.apache.org/plugins/maven-source-plugin/)         | Create JAR archive with source code                    | Apache License 2.0               |
| [Maven Surefire Plugin](https://maven.apache.org/surefire/maven-surefire-plugin/)   | Unit testing                                           | Apache License 2.0               |
| [OSS Index Maven Plugin](https://sonatype.github.io/ossindex-maven/maven-plugin/)   | Checking Dependencies Vulnerability                    | ASL2                             |
| [Versions Maven Plugin](https://www.mojohaus.org/versions-maven-plugin/)            | Checking if dependencies updates are available         | Apache License 2.0               |