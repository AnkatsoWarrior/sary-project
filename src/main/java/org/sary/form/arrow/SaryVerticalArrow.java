

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
 * Represente une fleche orientee verticalement
 * 
 * @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
 *
 */
public abstract class SaryVerticalArrow extends SaryForm {

	private static final long serialVersionUID = 1L;

	// Largeur de la tete de la fleche
	protected int headHeight = 10;

	
	public int getHeadHeight() {
		return headHeight;
	}

	
	public void setHeadHeight(int headHeight) {
		if (headHeight > 0) {
			this.headHeight = headHeight;
		}

	}

	
	@Override
	public void setDim(Dimension dimension) {
		if (dimension.getHeight() > headHeight) {
			super.setDim(dimension);
		} else {
			super.setDim(new Dimension((int) dimension.getWidth(), headHeight));
		}

	}

	
	@Override
	public void setDim(int width, int height) {
		if (height > headHeight) {
			super.setDim(width, height);
		} else {
			super.setDim(width, headHeight);
		}

	}

	
	@Override
	public void setHeight(int height) {
		if (height > headHeight) {
			super.setHeight(height);
		} else {
			super.setHeight(headHeight);
		}

	}
	

	@Override
	public void setRect(Rectangle rect) {
		if (rect.height > headHeight) {
			super.setRect(rect);
		} else {
			rect.height = headHeight;
			super.setRect(rect);
		}

	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract void draw(Graphics2D drawer);
}
