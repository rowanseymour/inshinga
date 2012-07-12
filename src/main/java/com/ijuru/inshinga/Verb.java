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

import java.util.ArrayList;
import java.util.List;

/**
 * A verb
 */
public class Verb {
	
	protected String presentStem;
	protected String pastStem;
	protected List<String> meanings = new ArrayList<String>();
	
	public Verb(String presentStem, String pastStem) {
		this.presentStem = presentStem;
		this.pastStem = pastStem;
	}

	/**
	 * @return the presentStem
	 */
	public String getPresentStem() {
		return presentStem;
	}

	/**
	 * @return the pastStem
	 */
	public String getPastStem() {
		return pastStem;
	}
	
	/**
	 * @return the meanings
	 */
	public List<String> getMeanings() {
		return meanings;
	}

	/**
	 * @param meanings the meanings
	 */
	public void setMeanings(List<String> meanings) {
		this.meanings = meanings;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Verb [presentStem=" + presentStem + ", pastStem=" + pastStem + ", meanings=" + meanings + "]";
	}
}
