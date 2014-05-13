

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
 * Represente une fleche tournee vers la gauche
 * 
 * @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
 *
 */
public class SaryLeftArrow extends SaryHorizontalArrow {


	private static final long serialVersionUID = 1L;

	@Override
	public void draw(Graphics2D drawer) {
		if (visible) {

			final int h2 	= rect.height / 2;
			final int h4 	= rect.height / 4;
			
//			final int w 	= rect.width - headWidth;
			final int x  	= rect.x; int y = rect.y;
			
			final int[] xPoints = new int[] {	// Preparation des abscisses des points composant le contour de la fleche 
				x		, x + headWidth,	x + headWidth, 	x + rect.width,	x + rect.width,	x + headWidth, 	x + headWidth
			};
			
			final int[] yPoints = new int[] {  	// Preparation des ordonnees des points composant le contour de la fleche 
				y + h2	, y,				y + h4,			y + h4, 		y + h2 + h4,	y + h2 + h4,	y + rect.height
			};
			
			final Polygon arrow  = new Polygon(xPoints, yPoints, xPoints.length);
			
			drawer.setColor(background);
			
			drawer.fillPolygon(arrow);
			
			drawer.setColor(foreground);

			drawer.drawPolygon(arrow);
		}
	}

}
