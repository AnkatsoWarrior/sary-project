
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
package org.sary.form;

import java.awt.Graphics2D;
/**
*
* @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
*/
public class SaryModel extends SaryForm {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(Graphics2D drawer) {
		if(visible) {
			
			drawer.setColor(background);
			
			// dessiner ici le fond ...
			
			
			drawer.setColor(foreground);
			
			// dessiner ici le contour ...
		}
	}

}