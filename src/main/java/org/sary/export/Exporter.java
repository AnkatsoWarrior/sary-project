
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

package org.sary.export;

import org.sary.canvas.SaryCanvas;
import org.sary.exceptions.SaryExportException;
import org.sary.form.SaryFormat;
/**
*
* @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
*/
public interface Exporter {

	/**
	 * Permet de specifier le format de l'image a generer.
	 * 
	 * @param format
	 *            Voir {@link org.sary.form.SaryFormat}
	 * @return l'instance actuelle de {@linkorg.sary.export.Exporter} utilisee
	 */
	public Exporter setFormat(SaryFormat format);

	/**
	 * Permet de specifier le chemin et le nom du fichier image a generer.
	 * 
	 * @param output
	 *            le chemin et le nom du fichier image a generer. Exemple :
	 *            C:/image.png
	 * @return l'instance actuelle de {@linkorg.sary.export.Exporter} utilisee
	 */
	public Exporter setOutput(String output);

	/**
	 * Permet de specifier le {@link org.sary.canvas.SaryCanvas} definissant les
	 * elements de l'image a generer
	 * 
	 * @param canvas
	 *            instance de {@link org.sary.canvas.SaryCanvas}
	 * @return l'instance actuelle de {@linkorg.sary.export.Exporter} utilisee
	 */
	public Exporter setCanvas(SaryCanvas canvas);

	/**
	 * Permet de recuperer le format specifie pour l'image a generer
	 * 
	 * @return le format de l'image a generer (voir
	 *         {@link org.sary.form.SaryFormat})
	 */
	public SaryFormat getFormat();

	/**
	 * Permet de recuperer le chemin et le nom du fichier image a generer.
	 * 
	 * @return le chemin et le nom du fichier image a generer.
	 */
	public String getOutput();

	/**
	 * Permet de recuperer le {@link org.sary.canvas.SaryCanvas} definissant les
	 * elements de l'image a generer
	 * 
	 * @return le {@link org.sary.canvas.SaryCanvas} definissant les elements de
	 *         l'image a generer
	 */
	public SaryCanvas getCanvas();

	/**
	 * Permet de lancer la generation de l'image
	 * 
	 * @throws SaryExportException
	 */
	public void export() throws SaryExportException;
}
