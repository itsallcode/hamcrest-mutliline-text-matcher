# hamcrest-mutliline-text-matcher

This project provides a [Hamcrest](http://hamcrest.org/) matcher that gives you better diagnostics for multi-line text in case of mismatches.

[![Download](https://api.bintray.com/packages/itsallcode/itsallcode/hamcrest-mutliline-text-matcher/images/download.svg) ](https://bintray.com/itsallcode/itsallcode/hamcrest-mutliline-text-matcher/_latestVersion)

## Usage

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

## Development

### Publishing to JCenter

1. Add the following to your `~/.m2/settings.xml`:

    ```xml
    <servers>
        <server>
            <id>bintray-maven-repo</id>
            <username>[bintray-username]</username>
            <password>[bintray-api-key]</password>
        </server>
    </servers>
    ```

1. Checkout the `develop` branch.
1. Update version in `pom.xml` and `README.md`, commit and push.
1. Run command

    ```bash
    mvn deploy
    ```

1. Create a [release](https://github.com/itsallcode/openfasttrace/releases) on GitHub.
1. Sign in at [bintray.com](https://bintray.com)
1. Go to the [bintray project page](https://bintray.com/itsallcode/itsallcode/openfasttrace)
1. There should be a notice saying "You have 6 unpublished item(s) for this package". Click the "Publish" link. Binaries will be available for download at [jcenter](https://jcenter.bintray.com/org/itsallcode/openfasttrace/)
1. Publish to Maven Central by clicking the "Sync" button at https://bintray.com/itsallcode/itsallcode/openfasttrace#central. After some time the new version will appear at https://repo1.maven.org/maven2/org/itsallcode/openfasttrace/.
