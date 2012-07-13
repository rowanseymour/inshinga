/**
 * Copyright 2011 Rowan Seymour
 * 
 * This file is part of Inshinga.
 *
 * Inshinga is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Inshinga is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Inshinga. If not, see <http://www.gnu.org/licenses/>.
 */

package com.ijuru.inshinga;

import junit.framework.TestCase;

/**
 * Unit test for utils
 */
public class SpellingTest extends TestCase {
	
	/**
	 * Test for correct
	 */
	public void test_correct() {
		assertEquals("ndakora", Spelling.correct("nrakora"));
	}
	
	/**
	 * Test for changeDown
	 */
	public void test_changeDown() {
		assertEquals("ndagu", Spelling.changeDown("ndaku"));
		assertEquals("aradu", Spelling.changeDown("aratu"));
		assertEquals("kuda", Spelling.changeDown("kuta"));
	}
	
	/**
	 * Test for applyVerbModifier
	 */
	public void test_applyVerbModifier() {
		assertNull(Spelling.applyVerbModifier("zi", null));
		assertEquals("koze", Spelling.applyVerbModifier("kora", "-ze"));
		assertEquals("kunze", Spelling.applyVerbModifier("kunda", "-nze"));
		assertEquals("giye", Spelling.applyVerbModifier("jya", "giye"));
		assertEquals("ciye inyuma", Spelling.applyVerbModifier("ca inyuma", "-ciye"));
		assertEquals("igerejeho", Spelling.applyVerbModifier("igerezaho", "-jeho"));
	}
	
	/**
	 * Test for stripVerbStem
	 */
	public void test_stripVerbStem() {
		assertEquals("ko", Spelling.stripVerbStem("kora"));
		assertEquals("ku", Spelling.stripVerbStem("kunda"));
		assertEquals("", Spelling.stripVerbStem("jyayo"));
	}
	
	/**
	 * Test for isVowel
	 */
	public void test_isVowel() {
		for (char ch : new char[]{ 'a', 'e', 'i', 'o', 'u' })
			assertTrue(Spelling.isVowel(ch));
		for (char ch : new char[]{ 's', 'x', 'y', ' ' })
			assertFalse(Spelling.isVowel(ch));
	}
	
	/**
	 * Test for isLabialConsonant
	 */
	public void test_isLabialConsonant() {
		for (char ch : new char[]{ 'b', 'f', 'm', 'p', 'v' })
			assertTrue(Spelling.isLabialConsonant(ch));
		for (char ch : new char[]{ 'a', 'c', 'd', 'e', 'g', 'h', 'x', ' ' })
			assertFalse(Spelling.isLabialConsonant(ch));
	}
	
	/**
	 * Test for isFrontConsonant
	 */
	public void test_isFrontConsonant() {
		for (char ch : new char[]{ 'c', 'f', 'h', 'k', 'p', 's', 't' })
			assertTrue(Spelling.isFrontConsonant(ch));
		for (char ch : new char[]{ 'a', 'b', 'd', 'x', ' ' })
			assertFalse(Spelling.isFrontConsonant(ch));
	}
}
