/*
 * Copyright (C) 2008-2012 Nabil Andriantomanga <nabil.arrowbase at gmail.com>
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
package org.sary.form.arrow;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.sary.form.SaryForm;

/**
 * Represente une fleche orientee horizontalement
 * 
 * @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
 */
public abstract class SaryHorizontalArrow extends SaryForm {

	private static final long serialVersionUID = 1L;
	
	// Largeur de la tete de la fleche
	protected int headWidth = 10;

	
	
	/**
	 * Permet de specifier la dimension de la fleche. Ne pas accepter une
	 * largeur plus petite que la largeur de la tete de la fleche.
	 * 
	 * @param dimension la nouvelle dimension de la fleche
	 */
	@Override
	public void setDim(Dimension dimension) {
		if (dimension.getWidth() >= headWidth) {
			super.setDim(dimension);
		} else {
			super.setDim(new Dimension(headWidth, (int) dimension.getHeight()));
		}

	}

	
	
	/**
	 * Permet de specifier la dimension de la fleche. Ne pas accepter une
	 * largeur plus petite que la largeur de la tete de la fleche.
	 * 
	 * @param width la nouvelle largeur de la fleche
	 * @param height la nouvelle hauteur de la fleche 
	 */
	@Override
	public void setDim(int width, int height) {
		if (width >= headWidth) {
			super.setDim(width, height);
		} else {
			super.setDim(headWidth, height);
		}

	}

	
	
	/**
	 * Permet de specifier la largeur de la fleche
	 * 
	 * @param width la nouvelle largeur de la fleche 
	 */
	@Override
	public void setWidth(int width) {
		if (width > headWidth) {
			super.setWidth(width);
		} else {
			super.setWidth(headWidth);
		}

	}

	
	
	/**
	 * Permet de recuperer la largeur de la tete de la fleche.
	 * 
	 * @return la largeur de la tete de la fleche
	 */
	public int getHeadWidth() {
		return headWidth;
	}

	
	
	/**
	 * Permet de specifier la largeur de la tete de la fleche
	 * 
	 * @param headWidth
	 *            la nouvelle largeur de la tete de la fleche
	 */
	public void setHeadWidth(int headWidth) {
		if (headWidth > 0) {
			this.headWidth = headWidth;
		}

	}

	
	/**
	 * Permet de specifier le rectangle definissant le perimetre
	 * de la forme
	 * 
	 * @param rect le rectangle definissant le perimetre de la forme
	 */
	@Override
	public void setRect(Rectangle rect) {
		if(rect.width > headWidth) {
			super.setRect(rect);
		} else {
			rect.width = headWidth;
			super.setRect(rect);
		}
		
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract void draw(Graphics2D drawer);
}
