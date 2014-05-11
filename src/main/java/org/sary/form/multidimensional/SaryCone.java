package org.sary.form.multidimensional;

import java.awt.Graphics2D;
import java.awt.Polygon;

import org.sary.form.SaryForm;

public class SaryCone  extends SaryForm {

	@Override
	public void draw(Graphics2D drawer) {
		
		if(visible) {
			
			int h4 = rect.width / 4;
			
			Polygon cone = new Polygon();
			cone.addPoint(rect.x, rect.y + rect.height - h4/2);
			cone.addPoint(rect.x + rect.width/2, rect.y);
			cone.addPoint(rect.x + rect.width, rect.y + rect.height - h4/2);
	
			drawer.setColor(background);
			drawer.fillPolygon(cone);
			drawer.fillArc(rect.x, rect.y + rect.height - h4, rect.width, h4, 0, -180);
			
			
			drawer.setColor(foreground);
			drawer.drawPolygon(cone);
			drawer.drawArc(rect.x, rect.y + rect.height - h4, rect.width, h4, 0, -180);
			
			drawer.setColor(background);
			drawer.drawLine(rect.x + stroke, rect.y + rect.height -h4/2, rect.x + rect.width -stroke, rect.y + rect.height -h4/2);
		}
		
	}
}
