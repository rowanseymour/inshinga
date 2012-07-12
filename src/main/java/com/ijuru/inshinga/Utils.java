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

import java.util.ArrayList;
import java.util.List;

/**
 * General utility methods
 */
public class Utils {

	/**
	 * Parses a delimited string and returns non-empty values
	 * @param input the input
	 * @param delimiter the delimiter
	 * @return the values
	 */
	public static List<String> parseDelimitedStrings(String input, String delimiter) {
		List<String> vals = new ArrayList<String>();
		
		// Skip parsing empty strings
		if (input == null || input.length() == 0)
			return vals;
		
		for (String token : input.split(delimiter)) {
			token = token.trim();
			
			if (token.length() > 0)
				vals.add(token);
		}
		return vals;
	}
}
