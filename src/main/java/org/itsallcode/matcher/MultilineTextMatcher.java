package org.itsallcode.matcher;

import java.util.ArrayList;
import java.util.List;

/*-
 * #%L
 * %%
 * Copyright (C) 2016 - 2017 itsallcode.org
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class implements a matcher for multi-line text that helps finding the
 * differences more quickly.
 */
public class MultilineTextMatcher extends TypeSafeMatcher<String>
{
	private static final String LINE_SEPARATOR = "\n";
	private static final String LINE_ENDING = "\\r\\n|\\r|\\n";
	private final String originalText;

	public MultilineTextMatcher(final String originalText)
	{
		this.originalText = originalText;
	}

	/**
	 * Match the text against the original text.
	 * 
	 * A full match (including line separators) is required.
	 * 
	 * @param text the text to be matched against the original text.
	 */
	@Override
	public boolean matchesSafely(final String text)
	{
		return text.equals(this.originalText);
	}

	@Override
	protected void describeMismatchSafely(final String text, final Description mismatchDescription)
	{
		final List<String> originalLines = splitPreservingNewLines(this.originalText);
		final List<String> lines = splitPreservingNewLines(text);

		final int originalLineCount = originalLines.size();
		final int lineCount = lines.size();

		mismatchDescription.appendText(describeLineCount(lineCount));

		for (int i = 0; i < lineCount; ++i)
		{
			final String line = lines.get(i);
			if (i > originalLineCount - 1)
			{
				mismatchDescription.appendText("+>> ");
			} else if (line.equals(originalLines.get(i)))
			{
				mismatchDescription.appendText("    ");
			} else
			{
				mismatchDescription.appendText(">>> ");
			}
			mismatchDescription.appendText(line);
			mismatchDescription.appendText(LINE_SEPARATOR);
		}
	}

	private String describeLineCount(final int lineCount)
	{
		return "(" + lineCount + " lines)" + LINE_SEPARATOR;
	}

	@Override
	public void describeTo(final Description description)
	{
		final List<String> originalLines = splitPreservingNewLines(this.originalText);
		final int originalLineCount = originalLines.size();

		description.appendText(describeLineCount(originalLineCount));
		for (final String line : originalLines)
		{
			description.appendText("    ");
			description.appendText(line);
			description.appendText(LINE_SEPARATOR);
		}
	}

	/**
	 * Factory method for multi-line text matcher
	 * 
	 * @param line a line of text
	 * @return the matcher
	 */
	public static MultilineTextMatcher matchesAllLines(final String... lines)
	{
		return new MultilineTextMatcher(String.join(LINE_SEPARATOR, lines));
	}

	private List<String> splitPreservingNewLines(final String text)
	{
		final String lineSplittingRegEx = "(?<=" + LINE_ENDING + ")";
		final List<String> lines = new ArrayList<>();
		for (String line : text.split(lineSplittingRegEx))
		{
			line = line.replace('\n', '\u240A').replace('\r', '\u240D').replace('\t', '\u2409');
			lines.add(line);
		}
		return lines;
	}
}
