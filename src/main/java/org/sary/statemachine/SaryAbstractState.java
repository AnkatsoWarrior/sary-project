/*
 * Copyright (C) 2014 Nabil Andriantomanga <nabil.arrowbase at gmail.com>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see <http://www.gnu.org/licenses/>.
 */

package org.sary.statemachine;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.sary.form.SaryForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SaryAbstractState extends SaryForm {

	private static final Logger LOG = LoggerFactory
			.getLogger(SaryAbstractState.class);

	private static final String DIM_CHANGE_ERR_MSG = "Le dimensionnement des etats "
			+ "est gere automatiquement";

	private static final long serialVersionUID = 1L;

	/**
	 * Etiquette de l'etat
	 */
	protected String label;

	/*
	 * Generateur d'identifiant pour les etats
	 */
	private static int idGen = 0;

	/*
	 * Identifiant de l'etat
	 */
	protected int id;

	public SaryAbstractState() throws Exception {
		super();

		/////////////////////////////// Ne pas utiliser encore
		throw new Exception("N'utilisez pas encore la machine à etats car son implémentation n'est pas encore fini");
		/*
		
		id 		= ++idGen;
		label 	= "State";

		LOG.debug("Creation de l'etat {}-{}", label, id);
		*/
	}

	@Override
	public void setDim(Dimension dimension) {

		LOG.error(DIM_CHANGE_ERR_MSG);

	}

	@Override
	public void setDim(int width, int height) {

		LOG.error(DIM_CHANGE_ERR_MSG);

	}

	@Override
	public void setWidth(int width) {

		LOG.error(DIM_CHANGE_ERR_MSG);

	}

	@Override
	public void setHeight(int height) {

		LOG.error(DIM_CHANGE_ERR_MSG);

	}

	@Override
	public void setRect(Rectangle rect) {

		LOG.error(DIM_CHANGE_ERR_MSG);

	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
