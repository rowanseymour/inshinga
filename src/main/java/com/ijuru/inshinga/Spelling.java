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
	private static final String[] SUFFIXES = new String[]{ "mo", "ho", "yo" };
	
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
	 * Applies a verb modifier to its stem to get the past tense stem
	 * @param stem the verb stem
	 * @param modifier the verb modifier
	 * @return the past tense stem
	 */
	public static String applyVerbModifier(String stem, String modifier) {
		if (modifier == null)
			return null;
		
		if (!modifier.startsWith("-"))
			return modifier;
		
		// Verb may have auxillary words
		String[] words = stem.split(" ");
		String verb = words[0];
		
		String strippedStem = stripVerbStem(verb);
		if (strippedStem != null) {
			String pastStem = modifier.replace("-", strippedStem);
			
			// Re-append aux words
			for (int w = 1; w < words.length; ++w)
				pastStem = pastStem + " " + words[w];
			
			return pastStem;
		}
		
		return modifier;
		
		/*
		$words = explode(' ', $revision->getLemma());
		$verb = $words[0];
		array_shift($words);
		$extra = implode(' ', $words);
		$stem = rw_verbstem($verb);

		if ($stem) {
			$past = str_replace('-', $stem, $modifier);
			return '-'.$past.($extra ? ' '.$extra : '');
		}

		return $revision->getModifier();
	}*/
	}
	
	/**
	 * Strips a verb stem to remove the present tense specific ending, 'kora' -> 'ko'
	 * @param stem the verb stem
	 * @return the stripped stem
	 */
	public static String stripVerbStem(String stem) {
		// Remove pronominal suffixes
		for (String suffix : SUFFIXES) {
			if (stem.endsWith(suffix)) {
				stem = stem.substring(0, stem.length() - 2);
				break;
			}
		}
	    
	    for (int ch = stem.length() - 1; ch >= 0; ch--) {
	    	if (!Spelling.isVowel(stem.charAt(ch))) {
	    		if (ch == 0)
	    			return stem.substring(0, ch);
	    		if (Spelling.isVowel(stem.charAt(ch - 1)))
	    			return stem.substring(0, ch);
	    	}
	    }
	    return null;
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
