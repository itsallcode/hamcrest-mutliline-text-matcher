# hamcrest-mutliline-text-matcher

This project provides a [Hamcrest](http://hamcrest.org/) matcher that gives you better diagnostics for multi-line text in case of mismatches.

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