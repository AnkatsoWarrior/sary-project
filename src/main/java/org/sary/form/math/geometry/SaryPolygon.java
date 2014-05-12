
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
package org.sary.form.math.geometry;

import java.awt.Graphics2D;
import java.awt.Polygon;

import org.sary.form.SaryForm;
/**
*
* @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
*/
public abstract class SaryPolygon extends SaryForm {


	private static final long serialVersionUID = 1L;

	public static class Type {
		
		public static final int SQUARE 		= 4;
		
		public static final int PENTAGON 	= 5;
		
		public static final int HEXAGON 	= 6;
		
		public static final int HEPTAGON    = 7;
		
		public static final int OCTAGON 	= 8;
		
		public static final int NONAGON     = 9;
		
		public static final int DECAGON 	= 10;
		
	}
	
	protected int type = SaryPolygon.Type.SQUARE;	// un carré par defaut 
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(Graphics2D drawer) {
		if (visible) {

			int radius = rect.width > rect.height ? rect.height / 2
					: rect.width / 2;

			int middleX = rect.x + radius;
			int middleY = rect.y + radius;

			Polygon polygon = new Polygon();

			for (int i = 0; i < type; i++) {
				polygon.addPoint(
						(int) (middleX + radius * Math.cos(i * 2 * Math.PI / type)),
						(int) (middleY + radius * Math.sin(i * 2 * Math.PI / type)));
			}

			drawer.setColor(background);

			drawer.fillPolygon(polygon);
			
			drawer.setColor(foreground);

			drawer.drawPolygon(polygon);
		}
	}

}