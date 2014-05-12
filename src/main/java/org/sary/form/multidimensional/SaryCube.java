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

package org.sary.form.multidimensional;

import java.awt.Graphics2D;
import java.awt.Polygon;

import org.sary.form.SaryForm;

/**
 * 
 * @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
 */
public class SaryCube extends SaryForm {

	private static final long serialVersionUID = 1L;

	public SaryCube() {
		super();
		// throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void draw(Graphics2D drawer) {

		if (visible) {

			int side = rect.width > rect.height ? rect.height : rect.width;
			int cubeSide = 3 * side / 4;

			int squareX = rect.x;
			int squareY = rect.y + side - cubeSide;

			int depX = squareX + 3* cubeSide/8; // squareX + 3 * side / 8;

			int depY = squareY - side / 4;
			int depY2 = squareY + cubeSide - side / 4;

			Polygon firstPolygon = new Polygon();
			firstPolygon.addPoint(squareX, squareY);
			firstPolygon.addPoint(depX, depY);
			firstPolygon.addPoint(rect.x + side, depY);
			firstPolygon.addPoint(squareX + cubeSide, squareY);

			Polygon secondPolygon = new Polygon();
			secondPolygon.addPoint(squareX + cubeSide, squareY);
			secondPolygon.addPoint(rect.x + side, depY);
			secondPolygon.addPoint(rect.x + side, depY2);
			secondPolygon.addPoint(squareX + cubeSide, squareY + cubeSide);

			drawer.setColor(background);

			drawer.fillRect(squareX, squareY, cubeSide, cubeSide);

			drawer.fillPolygon(firstPolygon);
			drawer.fillPolygon(secondPolygon);

			drawer.setColor(foreground);

			drawer.drawRect(squareX, squareY, cubeSide, cubeSide);

			drawer.drawPolygon(firstPolygon);
			drawer.drawPolygon(secondPolygon);
		}
	}

}
