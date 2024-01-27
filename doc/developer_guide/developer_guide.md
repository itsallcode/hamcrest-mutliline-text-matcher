# Developer Guide

## Generate / update license file header

```bash
mvn license:update-file-header
```

## Run local sonar analysis

```bash
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent package sonar:sonar \
    -Dsonar.token=[token]
```

See analysis results at https://sonarcloud.io/dashboard?id=org.itsallcode%3Ahamcrest-mutliline-text-matcher

## Check for updated dependencies / plugins

```bash
mvn versions:display-dependency-updates
```

```bash
mvn versions:display-plugin-updates
```

## Publishing to Maven Central

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

1. Checkout the `main` branch.
1. Update version in `pom.xml`, commit and push.
1. Run command

    ```bash
    mvn -DskipSigningArtifacts=false clean deploy
    ```

1. Create a [release](https://github.com/itsallcode/hamcrest-mutliline-text-matcher/releases) of the `main` branch on GitHub.
1. After some time the release will be available at [Maven Central](https://repo1.maven.org/maven2/org/itsallcode/hamcrest-mutliline-text-matcher/).
