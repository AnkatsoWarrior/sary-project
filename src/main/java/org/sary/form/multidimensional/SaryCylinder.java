
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

import org.sary.form.SaryForm;
/**
*
* @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
*/
public class SaryCylinder extends SaryForm {


	private static final long serialVersionUID = 1L;

	public SaryCylinder() {
		super();
		// throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void draw(Graphics2D drawer) {
		
		if(visible) {
			
			int h4 = rect.width / 4;
			int h2 = h4 / 2;
			
			drawer.setColor(background);
			
			drawer.fillRect(rect.x, rect.y + h4 /2, rect.width, rect.height - h4);
			drawer.fillOval(rect.x, rect.y, rect.width, h4);
			drawer.fillArc(rect.x, rect.y + rect.height - h4, rect.width, h4, 0, -180);
			
			
			drawer.setColor(foreground);
			
			drawer.drawOval(rect.x, rect.y, rect.width, h4);
			
			drawer.drawLine(rect.x, rect.y + h2, rect.x , rect.y + rect.height - h2);
			drawer.drawLine(rect.x + rect.width, rect.y + h2, rect.x + rect.width, rect.y + rect.height - h2);
			
			drawer.drawArc(rect.x, rect.y + rect.height - h4, rect.width, h4, 0, -180);
		}
		
	}

}
