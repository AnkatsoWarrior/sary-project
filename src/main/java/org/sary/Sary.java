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
package org.sary;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.List;

import org.sary.canvas.SaryCanvas;
import org.sary.exceptions.SaryExportException;
import org.sary.export.Exporter;
import org.sary.export.SaryExporter;
import org.sary.form.SaryForm;
import org.sary.form.SaryFormat;

/**
 * 
 * @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
 */
public class Sary {

	private SaryCanvas canvas = new SaryCanvas();

	
	/**
	 * Objet permettant d'exporter le canvas (l'ensemble des figures avec le
	 * fond défini par le sous forme de fichier image.
	 * 
	 * Ce fichier peut etre dans l'un des format suivant : jpg, png ou gif. Pour
	 * ce faire, il suffit d'utiliser l'implémentation <tt>SaryExporter</tt> de
	 * l'interface <tt>Exporter</tt>.
	 */
	private Exporter exporter = new SaryExporter();

	
	public SaryCanvas getCanvas() {
		return canvas;
	}

	
	public void setCanvas(SaryCanvas canvas) {
		this.canvas = canvas;
	}

	
	public Exporter getExporter() {
		return exporter;
	}

	
	public void setExporter(Exporter exporter) {
		this.exporter = exporter;
	}

	
	public void add(SaryForm saryForm) {
		canvas.add(saryForm);
	}

	
	public void remove(SaryForm saryForm) {
		canvas.remove(saryForm);
	}
	

	public boolean has(SaryForm saryForm) {
		return canvas.has(saryForm);
	}

	
	public List<SaryForm> getAll() {
		return canvas.getAll();
	}

	
	public boolean isEmpty(Rectangle space) {
		return canvas.isEmpty(space);
	}

	
	public void setBackground(Color background) {
		canvas.setBackground(background);
	}

	
	public void setForeground(Color foreground) {
		canvas.setForeground(foreground);
	}

	
	public Color getBackground() {
		return canvas.getBackground();
	}

	
	public Color getForeground() {
		return canvas.getForeground();
	}

	
	public void export(Exporter exporter) throws SaryExportException {
		final String defaultOutput = "sary";
		
		if (exporter.getFormat() == null) {
			
			exporter.setFormat(SaryFormat.PNG);
			
		}
		
		if (exporter.getOutput() == null) {
			
			exporter.setOutput(defaultOutput);
			
		} else if (exporter.getOutput().isEmpty()) {
			
			exporter.setOutput(defaultOutput);
			
		}
		
		if (exporter.getCanvas() == null) {
			exporter.setCanvas(canvas);
		}
		
		exporter.export();
	}

	
	public void export(SaryFormat format, String output)
			throws SaryExportException {
		this.exporter.setFormat(format).setOutput(output).setCanvas(canvas)
				.export();
	}

	
	public static void main(String[] args) {
		System.out.println("Hello from Sary "
				+ new SaryVersion().getVersionString() + " !");
	}
}
