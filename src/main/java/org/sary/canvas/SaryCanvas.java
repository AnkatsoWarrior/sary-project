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
package org.sary.canvas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.sary.form.SaryForm;
import org.sary.statemachine.Automaton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
 */
public class SaryCanvas {

	private List<SaryForm> saryForms = new ArrayList<SaryForm>();
	private Color background, foreground;
	private int padding, stroke;
	private String title;

	private static final Logger LG = LoggerFactory.getLogger(SaryCanvas.class);

	private Automaton automaton;

	public Automaton getAutomaton() {
		return automaton;
	}

	public void setAutomaton(Automaton automaton) {
		this.automaton = automaton;
	}

	public SaryCanvas() {
		super();
		setInitParams();
	}

	public void setInitParams() {
		
		LG.debug("Initialisation des parametres relatifs au canvas");
		
		padding = 20;
		stroke = 2;

		background = Color.white;
		foreground = Color.black;
	}

	public List<SaryForm> getSaryForms() {
		return saryForms;
	}

	public void add(SaryForm saryForm) {
		saryForms.add(saryForm);
	}

	public void remove(SaryForm saryForm) {
		saryForms.remove(saryForm);
	}

	public boolean has(SaryForm saryForm) {
		return saryForms.contains(saryForm);
	}

	public boolean isEmpty(Rectangle space) {
		for (Iterator<SaryForm> iterator = saryForms.iterator(); iterator
				.hasNext();) {
			if (iterator.next().getRect().intersects(space)) {
				return false;
			}
		}
		return true;
	}

	public List<SaryForm> getAll() {
		return saryForms;
	}

	public void drawAll(Graphics2D drawer) {

		LG.debug("En train de dessiner les formes ");
		
		Color lastColor = drawer.getColor();

		Dimension dimension = getDimension();
		drawer.setColor(background);
		drawer.fillRect(0, 0, (int) dimension.getWidth(),
				(int) dimension.getHeight());

		drawer.setStroke(new BasicStroke(stroke));

		for (Iterator<SaryForm> iterator = saryForms.iterator(); iterator
				.hasNext();) {
			iterator.next().draw(drawer);
		}

		drawer.setColor(foreground);

		if (title != null) {
			drawer.drawString(title, 20, 20);
		}

		drawer.setColor(lastColor);

	}

	public Dimension getDimension() {
		
		LG.debug("Recuperation de la dimension de l'image en cours");
		int width = 0;
		int height = 0;
		int limit = 0;

		Rectangle saryRect;
		SaryForm saryForm;

		for (Iterator<SaryForm> iterator = saryForms.iterator(); iterator
				.hasNext();) {

			saryForm = iterator.next();
			saryRect = saryForm.getRect();

			limit = saryRect.x + saryRect.width;

			if (limit > width) {
				width = limit + padding;
			}

			limit = saryRect.y + saryRect.height;

			if (limit > height) {
				height = limit + padding;
			}
		}

		return new Dimension(width, height);
	}

	public void setPadding(int padding) {
		if (padding > 0) {
			this.padding = padding;
		}
	}

	public int getPadding() {
		return padding;
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public Color getForeground() {
		return foreground;
	}

	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStroke() {
		return stroke;
	}

	public void setStroke(int stroke) {
		if (stroke > 0) {
			this.stroke = stroke;
		}
	}

}
