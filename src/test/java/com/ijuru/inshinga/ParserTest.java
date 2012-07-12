/**
 * Copyright 2011 Rowan Seymour
 * 
 * This file is part of Inshinga.
 *
 * Imibare is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Imibare is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Imibare. If not, see <http://www.gnu.org/licenses/>.
 */

package com.ijuru.inshinga;

import java.util.List;

import junit.framework.TestCase;

/**
 * Unit test for parser
 */
public class ParserTest extends TestCase {
	
	protected Parser parser = new Parser();

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		parser.initialize();
	}

	/**
	 * Test for parse method with stem checking
	 */
	public void testParse_withStemCheck() {	
		List<ParserResult> results = parser.parse("ndakora", true);
		assertEquals(1, results.size());
		assertEquals(new ParserResult(new Conjugation(ConjSubject.I, ConjTense.PRESENT, ConjObject.NONE), "kora"), results.get(0));
		
		results = parser.parse("ajya", true);
		assertEquals(2, results.size());
		assertEquals(new ParserResult(new Conjugation(ConjSubject.HE_SHE, ConjTense.NONE, ConjObject.NONE), "jya"), results.get(0));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_6, ConjTense.NONE, ConjObject.NONE), "jya"), results.get(1));
		
		results = parser.parse("irafasha", true);
		assertEquals(2, results.size());
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_4, ConjTense.PRESENT, ConjObject.NONE), "fasha"), results.get(0));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_9, ConjTense.PRESENT, ConjObject.NONE), "fasha"), results.get(1));
		
		results = parser.parse("iragufasha", true);
		assertEquals(4, results.size());
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_4, ConjTense.PRESENT, ConjObject.YOU_SG), "fasha"), results.get(0));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_4, ConjTense.PRESENT, ConjObject.CLASS_15), "fasha"), results.get(1));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_9, ConjTense.PRESENT, ConjObject.YOU_SG), "fasha"), results.get(2));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_9, ConjTense.PRESENT, ConjObject.CLASS_15), "fasha"), results.get(3));
	}
	
	/**
	 * Test for parse method without stem checking
	 */
	public void testParse_withoutStemCheck() {
		Parser parser = new Parser();
		parser.initialize();
		
		List<ParserResult> results = parser.parse("ndakora", false);
		assertEquals(4, results.size());
		assertEquals(new ParserResult(Conjugation.IMPERATIVE, "ndakora"), results.get(0));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.NONE, ConjTense.NONE, ConjObject.I), "dakora"), results.get(1));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.I, ConjTense.NONE, ConjObject.NONE), "dakora"), results.get(2));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.I, ConjTense.PRESENT, ConjObject.NONE), "kora"), results.get(3));
		
		results = parser.parse("ajya", false);
		assertEquals(3, results.size());
		assertEquals(new ParserResult(Conjugation.IMPERATIVE, "ajya"), results.get(0));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.HE_SHE, ConjTense.NONE, ConjObject.NONE), "jya"), results.get(1));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_6, ConjTense.NONE, ConjObject.NONE), "jya"), results.get(2));
		
		results = parser.parse("irafasha", false);
		assertEquals(5, results.size());
		assertEquals(new ParserResult(Conjugation.IMPERATIVE, "irafasha"), results.get(0));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_4, ConjTense.NONE, ConjObject.NONE), "rafasha"), results.get(1));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_9, ConjTense.NONE, ConjObject.NONE), "rafasha"), results.get(2));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_4, ConjTense.PRESENT, ConjObject.NONE), "fasha"), results.get(3));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_9, ConjTense.PRESENT, ConjObject.NONE), "fasha"), results.get(4));
		
		results = parser.parse("iragufasha", false);
		assertEquals(9, results.size());
		assertEquals(new ParserResult(Conjugation.IMPERATIVE, "iragufasha"), results.get(0));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_4, ConjTense.NONE, ConjObject.NONE), "ragufasha"), results.get(1));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_9, ConjTense.NONE, ConjObject.NONE), "ragufasha"), results.get(2));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_4, ConjTense.PRESENT, ConjObject.NONE), "gufasha"), results.get(3));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_9, ConjTense.PRESENT, ConjObject.NONE), "gufasha"), results.get(4));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_4, ConjTense.PRESENT, ConjObject.YOU_SG), "fasha"), results.get(5));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_4, ConjTense.PRESENT, ConjObject.CLASS_15), "fasha"), results.get(6));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_9, ConjTense.PRESENT, ConjObject.YOU_SG), "fasha"), results.get(7));
		assertEquals(new ParserResult(new Conjugation(ConjSubject.CLASS_9, ConjTense.PRESENT, ConjObject.CLASS_15), "fasha"), results.get(8));
	}
}
