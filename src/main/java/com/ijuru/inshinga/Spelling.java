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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Spelling utility methods
 */
public class Spelling {
	
	private static final char[] VOWELS = new char[]{ 'a', 'e', 'i', 'o', 'u' };
	private static final char[] LABIAL_CONSONANTS = new char[]{ 'b', 'f', 'm', 'p', 'v' };
	private static final char[] FRONT_CONSONANTS = new char[]{ 'c', 'f', 'h', 'k', 'p', 's', 't' };
	
	private static final Map<String, String> changeDownRules = new HashMap<String, String>();
	static {
		changeDownRules.put("ka", "ga");
		changeDownRules.put("ki", "gi");
		changeDownRules.put("ku", "gu");
		changeDownRules.put("ta", "da");
		changeDownRules.put("tu", "du");
	}
	
	/**
	 * Corrects spelling
	 * @param input the input
	 * @return
	 */
	public static String correct(String input) {
		return input.replace("nr", "nd");
	}
	
	/**
	 * Applies change down rule to the last consonant
	 * @param input the input
	 * @return the changed down input
	 */
	public static String changeDown(String input) {
		for (Entry<String, String> rule : changeDownRules.entrySet()) {
			if (input.endsWith(rule.getKey()))
				input = input.replace(rule.getKey(), rule.getValue());
		}
		return input;
	}
	
	/**
	 * Checks if character is a labial consonant
	 * @param ch the character
	 * @return true if its a labial
	 */
	public static boolean isVowel(char ch) {
		return Arrays.binarySearch(VOWELS, ch) >= 0;
	}
	
	/**
	 * Checks if character is a labial consonant
	 * @param ch the character
	 * @return true if its a labial
	 */
	public static boolean isLabialConsonant(char ch) {
		return Arrays.binarySearch(LABIAL_CONSONANTS, ch) >= 0;
	}
	
	/**
	 * Checks if character is a labial consonant
	 * @param ch the character
	 * @return true if its a labial
	 */
	public static boolean isFrontConsonant(char ch) {
		return Arrays.binarySearch(FRONT_CONSONANTS, ch) >= 0;
	}
}
