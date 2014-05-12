
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import java.io.Serializable;

/**
*
* @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
*/
public abstract class SaryForm implements Serializable {

	
	/*
	 * Rectangle definissant le perimetre de la forme
	 */
	protected Rectangle rect;

	
	/*
	 * Couleur de fond de la forme 
	 */
	protected Color background;

	
	/*
	 * Couleur de premier plan de la forme 
	 */
	protected Color foreground;

	
	/*
	 *	La forme est visible ou non  
	 */
	protected boolean visible;

	
	/*
	 * Epaisseur des traits de la forme
	 */
	protected int stroke;

	
	/*
	 * Valeur relative au largeur et hauteur de la forme
	 * par defaut
	 */
	protected static int defaultDimension;

	
	/*
	 *	Abscisse par defaut de la forme 
	 */
	protected static int defaultPosX;

	/*
	 *  Ordonnée par defaut de la forme
	 */
	protected static int defaultPosY;
	
	
	/*
	 * Pour la serialisation
	 */
	private static final long serialVersionUID = 1L;

	public SaryForm() {
		super();
		setDefaultParameters();
	}

	/**
	 * Permet d'appliquer les parametres par defaut
	 */
	public void setDefaultParameters() {

		// Paramétres par défaut

		defaultDimension = 50;
		defaultPosX = 20;
		defaultPosY = 20;

		// Dimensions et localisation par défaut

		rect = new Rectangle(defaultPosX, defaultPosY, defaultDimension,
				defaultDimension);

		// Les couleurs utilisées
		background = Color.white;
		foreground = Color.black;

		// Epaisseur des lignes
		stroke = 3;

		// Visibilité de la forme
		visible = true;
	}

	/**
	 * Permet de modifier la position de la forme dans un repere ou l'axe des
	 * abscisses est oriente vers la droite et l'axe des ordonnees est oriente
	 * vers le bas.
	 * 
	 * @param x
	 *            abscisse de la forme
	 * @param y
	 *            ordonnée de la forme
	 */
	public void setPos(int x, int y) {
		rect.x = x;
		rect.y = y;
	}

	
	
	/**
	 * Permet de modifier la position de la forme dans un repere ou l'axe des
	 * abscisses est oriente vers la droite et l'axe des ordonnees est oriente
	 * vers le bas.
	 * 
	 * @param pos
	 *            position de la forme (instance de {@link java.awt.Point})
	 */
	public void setPos(Point pos) {
		rect.x = pos.x;
		rect.y = pos.y;
	}

	
	
	/**
	 * Permet de specifier les dimensions de la forme
	 * 
	 * @param dimension
	 *            voir egalement {@link java.awt.Dimension}
	 */
	public void setDim(Dimension dimension) {
		rect.width = dimension.width;
		rect.height = dimension.height;
	}

	
	
	/**
	 * Permet de specifier les dimensions de la forme.
	 * 
	 * @param width
	 *            la largeur de la forme
	 * @param height
	 *            la hauteur de la forme
	 */
	public void setDim(int width, int height) {
		rect.width = width;
		rect.height = height;
	}

	
	
	/**
	 * Permet de recuperer la position de la forme dans le repere utilise
	 * 
	 * @return une instance de {@link java.awt.Point}
	 */
	public Point getPos() {
		return new Point(rect.x, rect.y);
	}

	
	
	/**
	 * Permet de specifier la largeur de la forme
	 * 
	 * @param width
	 *            la largeur de la forme
	 */
	public void setWidth(int width) {
		rect.width = width;
	}

	
	
	/**
	 * Permet de recuperer la largeur de la forme
	 * 
	 * @return la largeur de la forme
	 */
	public int getWidth() {
		return rect.width;
	}

	
	
	/**
	 * Permet de specifier la hauteur de la forme
	 * 
	 * @param height
	 *            la hauteur de la forme
	 */
	public void setHeight(int height) {
		rect.height = height;
	}

	
	
	/**
	 * Permet de recuperer la hauteur de la forme
	 * 
	 * @return la hauteur de la forme
	 */
	public int getHeight() {
		return rect.height;
	}

	
	
	/**
	 * Permet de recuperer le {@link java.awt.Rectangle} relatif a la forme
	 * 
	 * @return le {@link java.awt.Rectangle} relatif a la forme
	 */
	public Rectangle getRect() {
		return rect;
	}

	
	
	/**
	 * Permet de specifier un {@link java.awt.Rectangle} a la forme
	 * 
	 * @param rect
	 *            une instance de {@link java.awt.Rectangle}
	 */
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	
	
	/**
	 * Permet de recuperer la couleur de fond de la forme. Il s'agit d'une
	 * instance de {@link java.awt.Color}.
	 * 
	 * @return la couleur de fond de la forme.
	 */
	public Color getBackground() {
		return background;
	}

	
	
	/**
	 * Permet de speficier la couleur de fond de la forme. Il s'agit d'une
	 * instance de {@link java.awt.Color}.
	 * 
	 * @param background
	 *            la couleur de fond de la forme.
	 */
	public void setBackground(Color background) {
		this.background = background;
	}

	
	
	/**
	 * Permet de recuperer la couleur de premier plan de la forme. Il s'agit
	 * d'une instance de {@link java.awt.Color}.
	 * 
	 * @return la couleur de premier plan de la forme.
	 */
	public Color getForeground() {
		return foreground;
	}
	
	

	/**
	 * Permet de speficier la couleur de premier plan de la forme. Il s'agit
	 * d'une instance de {@link java.awt.Color}.
	 * 
	 * @param background
	 *            la couleur de premier plan de la forme.
	 */
	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}

	
	
	/**
	 * Permet de recuperer l'epaisseur des lignes utilise pour dessiner cette
	 * forme.
	 * 
	 * @return l'epaisseur des lignes
	 */
	public int getStroke() {
		return stroke;
	}
	
	

	/**
	 * Permet de specifier l'epaisseur des lignes pour dessiner cette forme
	 * 
	 * @param stroke
	 *            l'epaisseur des lignes
	 */
	public void setStroke(int stroke) {
		if (stroke > 0) {
			this.stroke = stroke;
		}
	}

	
	
	/**
	 * Permet de savoir si cette forme est visible ou non
	 * 
	 * @return la visibilite de cette forme
	 */
	public boolean isVisible() {
		return visible;
	}

	
	
	/**
	 * Permet de specifier la visibilite de cette forme
	 * 
	 * @param visible
	 *            la nouvelle visibilite de cette forme
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	

	/**
	 * Permet de dessiner la forme.
	 * 
	 * @param drawer
	 *            l'objet dessinateur. Il s'agit d'une instance de
	 *            {@link java.awt.Graphics}
	 */
	public abstract void draw(Graphics2D drawer);

}
