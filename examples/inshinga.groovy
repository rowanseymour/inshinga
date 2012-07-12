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

package com.ijuru.inshinga

import com.ijuru.inshinga.Parser
import com.ijuru.inshinga.ParserResult

/**
 * Console based groovy app which uses Inshinga library to parse verbs. For example, to
 * parse "ndakora" with stem checking:
 *
 * groovy -cp inshinga-1.0.jar inshinga.groovy ndakora
 */
public class Inshinga {

	/**
	 * Program main method
	 * @param args the console arguments
	 */
	public static void main(String[] args) {
		// Print usage message if we have wrong number of arguments
		if (args.length != 1) {
			println("Usage: inshinga <input>")
			return
		}
		
		// Get program arguments
		String input = args[0]

		// Create the parser
		def parser = new Parser()
		parser.initialize()

		for (def result in parser.parse(input, true)) {
			println(result)
		}
	}
}
