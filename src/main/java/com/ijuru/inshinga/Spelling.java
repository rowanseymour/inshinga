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

/**
 * Spelling utility methods
 */
public class Spelling {
	
	/**
	 * Corrects spelling
	 * @param input the input
	 * @return
	 */
	public static String correct(String input) {
		return input.replace("nr", "nd");
	}
	
	/**
	 * Reverses spelling changes that depend on the stem
	 * @param input the input
	 * @return
	 */
	public static String reverse(String input) {
		return input.replace("gu", "ku");
	}
}
