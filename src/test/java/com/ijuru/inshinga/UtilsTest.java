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

import java.util.List;

import junit.framework.TestCase;

/**
 * Unit test for utils
 */
public class UtilsTest extends TestCase {
	
	/**
	 * Test for parseDelimitedStrings
	 */
	public void test_parseDelimitedStrings() {
		List<String> result = Utils.parseDelimitedStrings(null, ",");
		assertEquals(0, result.size());
		
		result = Utils.parseDelimitedStrings("", ",");
		assertEquals(0, result.size());
		
		result = Utils.parseDelimitedStrings("A, B , C", ",");
		assertEquals(3, result.size());
		assertEquals("A", result.get(0));
		assertEquals("B", result.get(1));
		assertEquals("C", result.get(2));
	}
}
