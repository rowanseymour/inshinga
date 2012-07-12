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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import au.com.bytecode.opencsv.CSVReader;

/**
 * A verb parser
 */
public class Parser {
	
	/**
	 * Map of conjugation prefixes
	 */
	private class PrefixMap extends TreeMap<String, List<Conjugation>> {
		private static final long serialVersionUID = 1487104274039497957L;
	}
	
	private static final int MAX_PREFIX_LEN = 8;

	protected PrefixMap[] prefixesByLength = new PrefixMap[MAX_PREFIX_LEN + 1];
	protected Map<String, List<Verb>> stemMap = new TreeMap<String, List<Verb>>();
	
	/**
	 * Initializes the parser by making the lookup table
	 */
	public void initialize() {

		initializePrefixes();
		initializeStems();	
		
		//System.out.println("Inshinga library initialized. Prefixes generated by length:");
		//for (int pl = 1; pl <= MAX_PREFIX_LEN; ++pl)
			//System.out.println(" " + pl + ": " + prefixesByLength[pl].size());
	}

	/**
	 * Initializes the conjugation prefixes
	 */
	protected void initializePrefixes() {
		// Initialize the conjugation prefix maps for different lengths
		for (int len = 0; len <= MAX_PREFIX_LEN; ++len)
			prefixesByLength[len] = new PrefixMap();
			
		for (ConjSubject subject : ConjSubject.values()) {
			for (ConjTense tense : ConjTense.values()) {
				for (ConjObject object : ConjObject.values()) {
					
					Conjugation conjugation = new Conjugation(subject, tense, object);
					String prefix = conjugation.getForm();
					
					PrefixMap map = prefixesByLength[prefix.length()];
					List<Conjugation> conjs = null;
					
					// Get the list of possible conjugations for this prefix
					// or make one if there's no list yet
					if (!map.containsKey(prefix)) {
						conjs = new ArrayList<Conjugation>();
						map.put(prefix, conjs);
					}
					else
						conjs = map.get(prefix);
						
					conjs.add(conjugation);
				}
			}
		}
	}
	
	/**
	 * Initializes the verb stems
	 */
	protected void initializeStems() {
		try {
			// Load verbs from embedded CSV file
			InputStream in = getClass().getResourceAsStream("/verbs.csv");
			CSVReader reader = new CSVReader(new InputStreamReader(in));
		    String[] line;
		    while ((line = reader.readNext()) != null) {
		        Verb verb = new Verb(line[0], line[1]);
		        verb.setMeanings(Utils.parseDelimitedStrings(line[2], ","));
		        
		        addVerb(verb);
		    }
		    reader.close();
		}
		catch (IOException ex) {
			System.out.println("Error loading verb list");
		}
	}
	
	/**
	 * Adds a verb to the stem map
	 * @param verb the verb
	 */
	protected void addVerb(Verb verb) {
		if (verb.getPresentStem() != null) {
			if (!stemMap.containsKey(verb.getPresentStem()))
				stemMap.put(verb.getPresentStem(), new ArrayList<Verb>());
			
			stemMap.get(verb.getPresentStem()).add(verb);
		}
		
		if (verb.getPastStem() != null) {
			if (!stemMap.containsKey(verb.getPastStem()))
				stemMap.put(verb.getPastStem(), new ArrayList<Verb>());
			
			stemMap.get(verb.getPastStem()).add(verb);
		}
	}
	
	/**
	 * Parses an input
	 * @param input the input
	 * @return the possible results
	 */
	public List<ParserResult> parse(String input, boolean checkStem) {
		List<ParserResult> results = new ArrayList<ParserResult>();
		
		// Ignore inputs too short
		if (input.length() < 2)
			return results;
		
		// Try different prefix lengths from 1 > len(input)-1
		for (int pl = 0; pl <= Math.min(input.length() - 1, MAX_PREFIX_LEN); ++pl) {
			String inputPrefix = input.substring(0, pl);
			String inputStem = input.substring(pl);
			
			// If stem checking is enabled, then verify that stem maps to a verb
			List<Verb> verbs = stemMap.get(inputStem);
			if (checkStem && verbs == null)
				continue;
			
			// Apply reverse spelling rules
			inputPrefix = Spelling.reverse(inputPrefix);
			
			// Get map of prefixes to conjugations for this prefix length
			PrefixMap prefixMap = prefixesByLength[pl];
			
			for (String prefix : prefixMap.keySet()) {
				if (inputPrefix.equals(prefix)) {
					List<Conjugation> conjugations = prefixMap.get(prefix);
					
					for (Conjugation conjugation : conjugations)
						results.add(new ParserResult(conjugation, inputStem));
				}
			}
		}
		
		return results;
	}
}
