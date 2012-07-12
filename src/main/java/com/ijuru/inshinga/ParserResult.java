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

public class ParserResult {

	protected Conjugation conjugation;
	protected String stem;
	
	/**
	 * Constructs a new parser result
	 * @param conjugation
	 * @param stem
	 */
	public ParserResult(Conjugation conjugation, String stem) {
		this.conjugation = conjugation;
		this.stem = stem;
	}

	/**
	 * @return the conjugation
	 */
	public Conjugation getConjugation() {
		return conjugation;
	}

	/**
	 * @return the stem
	 */
	public String getStem() {
		return stem;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conjugation == null) ? 0 : conjugation.hashCode());
		result = prime * result + ((stem == null) ? 0 : stem.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParserResult other = (ParserResult) obj;
		if (conjugation == null) {
			if (other.conjugation != null)
				return false;
		} else if (!conjugation.equals(other.conjugation))
			return false;
		if (stem == null) {
			if (other.stem != null)
				return false;
		} else if (!stem.equals(other.stem))
			return false;
		return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParserResult [conjugation=" + conjugation + ", stem=" + stem + "]";
	}	
}
