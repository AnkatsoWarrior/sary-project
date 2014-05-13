

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

import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 * Represente une fleche tournee vers le bas
 * 
 * @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
 *
 */
public class SaryDownArrow extends SaryVerticalArrow {

	private static final long serialVersionUID = 1L;

	@Override
	public void draw(Graphics2D drawer) {
		if (visible) {

			final int w2 	= rect.width / 2;
			final int w4 	= rect.width / 4;
			
			final int x  	= rect.x; int y = rect.y;
			
			final int h 	= y + rect.height - headHeight;
			
			final int[] xPoints = new int[] {	// Preparation des abscisses des points composant le contour de la fleche 
				x + w4,	x + w2 + w4,	x + w2 + w4,					x + rect.width,					x + w2,				x,								x + w4
			};
			
			final int[] yPoints = new int[] {  	// Preparation des ordonnees des points composant le contour de la fleche 
				y,		y,				h,	h,	y + rect.height,	h,	h
			};
			
			final Polygon arrow  = new Polygon(xPoints, yPoints, xPoints.length);
			
			drawer.setColor(background);
			
			drawer.fillPolygon(arrow);
			
			drawer.setColor(foreground);

			drawer.drawPolygon(arrow);
		}
	}

}
