# hamcrest-mutliline-text-matcher

This project provides a [Hamcrest](http://hamcrest.org/) matcher that gives you better diagnostics for multi-line text in case of mismatches.

[![Build](https://github.com/itsallcode/hamcrest-mutliline-text-matcher/actions/workflows/build.yml/badge.svg)](https://github.com/itsallcode/hamcrest-mutliline-text-matcher/actions/workflows/build.yml)
[![Maven Central](https://img.shields.io/maven-central/v/org.itsallcode/hamcrest-mutliline-text-matcher.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:org.itsallcode%20a:hamcrest-mutliline-text-matcher)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=org.itsallcode%3Ahamcrest-mutliline-text-matcher&metric=alert_status)](https://sonarcloud.io/dashboard?id=org.itsallcode%3Ahamcrest-mutliline-text-matcher)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=org.itsallcode%3Ahamcrest-mutliline-text-matcher&metric=coverage)](https://sonarcloud.io/dashboard?id=org.itsallcode%3Ahamcrest-mutliline-text-matcher)

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

## Development


### Generate / update license file header

```bash
mvn license:update-file-header
```

## Run local sonar analysis

```bash
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent package sonar:sonar \
    -Dsonar.host.url=https://sonarcloud.io \
    -Dsonar.organization=itsallcode \
    -Dsonar.login=[token]
```

See analysis results at https://sonarcloud.io/dashboard?id=org.itsallcode%3Ahamcrest-mutliline-text-matcher

## Check for updated dependencies / plugins

```bash
mvn versions:display-dependency-updates
```

```bash
mvn versions:display-plugin-updates
```

### Publishing to JCenter

1. Add the following to your `~/.m2/settings.xml`:

    ```xml
    <settings>
        <servers>
            <server>
                <id>ossrh</id>
                <username>your-jira-id</username>
                <password>your-jira-pwd</password>
            </server>
        </servers>
        <profiles>
            <profile>
                <id>ossrh</id>
                <activation>
                    <activeByDefault>true</activeByDefault>
                </activation>
                <properties>
                    <gpg.executable>gpg</gpg.executable>
                    <gpg.passphrase>the_pass_phrase</gpg.passphrase>
                </properties>
            </profile>
        </profiles>
    </settings>
    ```

1. Checkout the `master` branch.
1. Update version in `pom.xml`, commit and push.
1. Run command

    ```bash
    mvn -DskipSigningArtifacts=false clean deploy
    ```

1. Create a [release](https://github.com/itsallcode/hamcrest-mutliline-text-matcher/releases) of the `master` branch on GitHub.
1. After some time the release will be available at [Maven Central](https://repo1.maven.org/maven2/org/itsallcode/hamcrest-mutliline-text-matcher/).
