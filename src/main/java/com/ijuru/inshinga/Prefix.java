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

/**
 * Prefix component of a conjugated verb, e.g. "nda" of "ndakora"
 */
public class Prefix implements Comparable<Prefix> {
	
	protected String form;
	
	/**
	 * Contructs a prefix from a form
	 * @param form the form, e.g. "nda"
	 */
	public Prefix(String form) {
		this.form = form;
	}
	
	/**
	 * Checks whether this prefix can precede the given stem according to spelling rules
	 * @param stem the stem
	 * @return true if prefix may precede the stem
	 */
	public boolean canPrecede(String stem) {
		char stemStart = stem.charAt(0);
		
		if (form.endsWith("n") && Spelling.isLabialConsonant(stemStart))
			return false;
		
		if ((form.endsWith("ta") || form.endsWith("tu")) && Spelling.isFrontConsonant(stemStart))
			return false;
		if ((form.endsWith("ka") || form.endsWith("ki") || form.endsWith("ku")) && Spelling.isFrontConsonant(stemStart))
			return false;
			
		return true;
	}
	
	/**
	 * Gets the form
	 * @return the form
	 */
	public String getForm() {
		return form;
	}
	
	/**
	 * @see java.lang.Comparable#compareTo(Object)
	 */
	public int compareTo(Prefix prefix) {
		return form.compareTo(prefix.form);
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((form == null) ? 0 : form.hashCode());
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
		Prefix other = (Prefix) obj;
		if (form == null) {
			if (other.form != null)
				return false;
		} else if (!form.equals(other.form))
			return false;
		return true;
	}
}
