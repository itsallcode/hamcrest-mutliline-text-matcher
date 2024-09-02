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

## Creating a Release on Maven Central and GitHub

1. Start the release workflow
  * Run command `gh workflow run release.yml --repo itsallcode/hamcrest-mutliline-text-matcher --ref main`
  * or go to [GitHub Actions](https://github.com/itsallcode/hamcrest-mutliline-text-matcher/actions/workflows/release.yml) and start the `release.yml` workflow on branch `main`.
2. Update title and description of the newly created [GitHub release](https://github.com/itsallcode/hamcrest-mutliline-text-matcher/releases).
3. After some time the release will be available at [Maven Central](https://repo1.maven.org/maven2/org/itsallcode/hamcrest-mutliline-text-matcher/).
1. Create a [release](https://github.com/itsallcode/hamcrest-mutliline-text-matcher/releases) of the `main` branch on GitHub.
1. After some time the release will be available at [Maven Central](https://repo1.maven.org/maven2/org/itsallcode/hamcrest-mutliline-text-matcher/).
