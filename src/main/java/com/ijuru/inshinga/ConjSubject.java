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
 * The subject in a verb conjugation
 */
public enum ConjSubject {

	NONE(""),
	I("n"),
	YOU_SG("u"),
	HE_SHE("a"),
	US("tu"),
	YOU_PL("mu"),
	THEM("ba"),
	CLASS_3("u"),
	CLASS_4("i"),
	CLASS_5("ri"),
	CLASS_6("a"),
	CLASS_7("ki"),
	CLASS_8("bi"),
	CLASS_9("i"),
	CLASS_10("zi"),
	CLASS_11("ru"),
	CLASS_12("ka"),
	CLASS_13("tu"),
	CLASS_14("bu"),
	CLASS_15("ku"),
	CLASS_16("ha");
	
	protected String form;
	
	/**
	 * Constructs a subject with a form
	 * @param form the form
	 */
	private ConjSubject(String form) {
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
