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
 * @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
 */
public class SaryPyramid extends SaryForm {

	private static final long serialVersionUID = 1L;

	@Override
	public void draw(Graphics2D drawer) {
		if (visible) {

			int h4 			= rect.width / 4;
			int newWidth 	= rect.width - h4;
			
			Polygon triangle1 = new Polygon();
			triangle1.addPoint(
					rect.x + newWidth, rect.y + rect.height);
			
			triangle1.addPoint(
					rect.x + newWidth / 2, rect.y);
			
			triangle1.addPoint(
					rect.x, rect.y + rect.height);
			
			Polygon triangle2 = new Polygon();
			triangle2.addPoint(
					rect.x + newWidth, rect.y + rect.height);
			
			triangle2.addPoint(
					rect.x + newWidth / 2, rect.y);
			
			triangle2.addPoint(
					rect.x + rect.width, rect.y + rect.height - h4);
			
			drawer.setColor(background);
			
			drawer.fillPolygon(triangle1);
			drawer.fillPolygon(triangle2);
			
			drawer.setColor(foreground);
			
			drawer.drawPolygon(triangle1);
			drawer.drawPolygon(triangle2);
		}
	}

}
