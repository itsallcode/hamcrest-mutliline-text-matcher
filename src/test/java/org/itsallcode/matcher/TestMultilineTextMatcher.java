package org.itsallcode.matcher;

/*-
 * #%L
 * Hamcrest multi-line text matcher
 * %%
 * Copyright (C) 2016 - 2018 itsallcode.org
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

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.hamcrest.Description;
import org.hamcrest.StringDescription;
import org.junit.Test;

public class TestMultilineTextMatcher
{
	private static final String STANDARD_TWO_LINE_TEXT = "Line 1\nLine 2";

	@Test
	public void testMatchesSafely()
	{
		assertThat(new MultilineTextMatcher(STANDARD_TWO_LINE_TEXT).matchesSafely(STANDARD_TWO_LINE_TEXT), is(true));
	}

	@Test
	public void testDoesNotMatchSafely()
	{
		assertThat(new MultilineTextMatcher(STANDARD_TWO_LINE_TEXT).matchesSafely("blah"), is(false));
	}

	@Test
	public void testDescribeMismatchSafelyLine1Different()
	{
		Description description = new StringDescription();
		MultilineTextMatcher matcher = new MultilineTextMatcher(STANDARD_TWO_LINE_TEXT);
		matcher.describeMismatchSafely("different", description);
		assertThat(description.toString(), equalTo("(1 lines)\n>>> different\n"));
	}

	@Test
	public void testDescribeMismatchSafelyDifferentLineCount()
	{
		Description description = new StringDescription();
		MultilineTextMatcher matcher = new MultilineTextMatcher(STANDARD_TWO_LINE_TEXT);
		matcher.describeMismatchSafely(STANDARD_TWO_LINE_TEXT + "\nLine 3", description);
		assertThat(description.toString(), equalTo("(3 lines)\n    Line 1␊\n>>> Line 2␊\n+>> Line 3\n"));
	}

	@Test
	public void testDescribeTo()
	{
		Description description = new StringDescription();
		MultilineTextMatcher matcher = new MultilineTextMatcher(STANDARD_TWO_LINE_TEXT);
		matcher.describeTo(description);
		assertThat(description.toString(), equalTo("(2 lines)\n    Line 1␊\n    Line 2\n"));
	}
}
