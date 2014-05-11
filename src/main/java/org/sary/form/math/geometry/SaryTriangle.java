
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
public class SaryTriangle extends SaryForm {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(Graphics2D drawer) {
		if (visible) {

			Polygon triangle = new Polygon();

			int middleX = rect.x + rect.width / 2;
			int endY = rect.y + rect.height;

			triangle.addPoint(rect.x, endY);
			triangle.addPoint(middleX, rect.y);
			triangle.addPoint(rect.x + rect.width, endY);

			drawer.setColor(background);

			drawer.fillPolygon(triangle);

			drawer.setColor(foreground);

			drawer.drawPolygon(triangle);
		}
	}

}
