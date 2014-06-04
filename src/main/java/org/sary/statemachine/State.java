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

package org.sary.statemachine;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class State extends SaryAbstractState {
	
	public State() throws Exception {
		super();
	}

	private static final Logger LOG = LoggerFactory.getLogger(State.class);
	
	private static final long serialVersionUID = 1L;
	
	private String checkLabel(String aLabel) {
		
		final String defaultLabel = "State" + id;
		
		if(aLabel == null) {
			return defaultLabel;
		}
		
		if(aLabel.isEmpty()) {
			return defaultLabel;
		}
		
		return aLabel;
	}
	
	@Override
	public void draw(Graphics2D drawer) {
		if(visible) {
			
			LOG.debug("En train de dessiner l'etat {}", id);
			
			drawer.setColor(background);

			drawer.fillRoundRect(rect.x, rect.y, rect.width, rect.height, 7, 7);

			drawer.setStroke(new BasicStroke(2));

			drawer.setColor(foreground);

			drawer.drawRoundRect(rect.x, rect.y, rect.width, rect.height, 7, 7);

			label = checkLabel(label);
			
			drawer.drawString(label, rect.x + 10 + label.length() / 2,
					rect.y + 5);

			drawer.setStroke(new BasicStroke(1));
			
		}
	}

	
}
