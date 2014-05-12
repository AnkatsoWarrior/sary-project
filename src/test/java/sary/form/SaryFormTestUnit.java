
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
package sary.form;

import java.awt.Color;

import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;
import org.sary.Sary;
import org.sary.exceptions.SaryExportException;
import org.sary.form.SaryFormat;
import org.sary.form.arrow.SaryRightArrow;
//import org.sary.form.math.geometry.*;
import org.sary.form.multidimensional.*;


/**
*
* @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
*/
public class SaryFormTestUnit {

	
	
	public void export() throws SaryExportException {
		
		// Preparing canvas and all default settings ...
		Sary sary = new Sary();			
		
		// Creating simple shapes ...
		
		SaryCylinder c = new SaryCylinder();
		c.setPos(100, 100);
		c.setDim(100, 200);
		c.setBackground(Color.yellow);
		
		sary.add(c);	// Adding shape to the manager ... 
		
		SaryPyramid p = new SaryPyramid();
		p.setPos(300, 100);
		p.setDim(100, 200);
		p.setBackground(Color.green);
		
		sary.add(p);	// Adding shape to the manager ... 
		
		// launch the export operation ...
		sary.export(SaryFormat.PNG, "Figure.png");
		
	}
	
	
	@Ignore
	@Test
	public void test() {
		try {
			export();
		} catch (SaryExportException e) {
			
			e.printStackTrace();
		}
	}
	
	@Ignore
	@Test 
	public void arrowTest() {
		Sary sary = new Sary();
		
		SaryRightArrow arrow = new SaryRightArrow();
		
		arrow.setDim(200, 50);
		arrow.setPos(200, 200);
		
		arrow.setForeground(Color.gray);
		arrow.setBackground(Color.cyan);
		
		sary.add(arrow);
		
		try {
			sary.export(SaryFormat.JPG, "fleche.jpg");
		} catch (SaryExportException e) {
			
			e.printStackTrace();
		}
	}
	
	
	@AfterClass
	public static void end() {
		System.out.println("test ended");
	}
}
