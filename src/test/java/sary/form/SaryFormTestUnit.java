package sary.form;

import java.awt.Color;

import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;
import org.sary.Sary;
import org.sary.exceptions.SaryExportException;
import org.sary.form.SaryFormat;
//import org.sary.form.math.geometry.*;
import org.sary.form.multidimensional.*;

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
	
	
	@AfterClass
	public static void end() {
		System.out.println("test ended");
	}
}
