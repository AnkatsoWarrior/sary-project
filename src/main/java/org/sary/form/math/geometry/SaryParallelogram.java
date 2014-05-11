
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
public class SaryParallelogram extends SaryForm {

	private int displacement = rect.width / 4; // par defaut

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		if(displacement >= 0 && displacement <= rect.width) {
			this.displacement = displacement;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(Graphics2D drawer) {
		if (visible) {

			Polygon parallelogram = new Polygon();
			parallelogram.addPoint(rect.x + displacement, rect.y);
			parallelogram.addPoint(rect.x + rect.width, rect.y);
			parallelogram.addPoint(rect.x + rect.width - displacement, rect.y
					+ rect.height);
			parallelogram.addPoint(rect.x, rect.x + rect.height);

			drawer.setColor(background);

			drawer.fillPolygon(parallelogram);

			drawer.setColor(foreground);

			drawer.drawPolygon(parallelogram);
		}
	}

}
