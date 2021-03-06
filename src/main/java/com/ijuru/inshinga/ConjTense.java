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
 * The tense marker in a verb conjugation
 */
public enum ConjTense {

	NONE(""),
	PRESENT("ra"),
	FUTURE("za");
	
	protected String form;
	
	/**
	 * Constructs a tense marker with a form
	 * @param form the form
	 */
	private ConjTense(String form) {
		this.form = form;
	}
	
	/**
	 * Gets the form
	 * @return the form
	 */
	public String getForm() {
		return form;
	}
}
