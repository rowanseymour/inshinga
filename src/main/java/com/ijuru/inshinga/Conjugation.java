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
 * A verb conjugation
 */
public class Conjugation {
	
	private ConjSubject subject;
	private ConjTense tense;
	private ConjObject object;
	
	public static Conjugation IMPERATIVE = new Conjugation(ConjSubject.NONE, ConjTense.NONE, ConjObject.NONE);
	
	public Conjugation(ConjSubject subject, ConjTense tense, ConjObject object) {
		if (subject == null || tense == null || object == null)
			throw new IllegalArgumentException("None of the constructor parameters can be null");
		
		this.subject = subject;
		this.tense = tense;
		this.object = object;
	}
	
	/**
	 * Gets the form
	 * @return the form
	 */
	public String getForm() {
		String raw = subject.getForm() + tense.getForm() + object.getForm();
		
		// Apply spelling correction rules
		return Spelling.correct(raw);
	}

	/**
	 * @return the subject
	 */
	public ConjSubject getSubject() {
		return subject;
	}

	/**
	 * @return the tense
	 */
	public ConjTense getTense() {
		return tense;
	}

	/**
	 * @return the object
	 */
	public ConjObject getObject() {
		return object;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((tense == null) ? 0 : tense.hashCode());
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
		Conjugation other = (Conjugation)obj;
		if (object != other.object)
			return false;
		if (subject != other.subject)
			return false;
		if (tense != other.tense)
			return false;
		return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Conjugation [subject=" + subject + ", tense=" + tense + ", object=" + object + "]";
	}
}
