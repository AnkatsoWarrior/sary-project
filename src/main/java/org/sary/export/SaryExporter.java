
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

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.sary.canvas.SaryCanvas;
import org.sary.exceptions.SaryExportException;
import org.sary.form.SaryFormat;
/**
*
* @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
*/
public class SaryExporter implements Exporter {

	private SaryFormat format;

	private String output;

	private SaryCanvas canvas;

	@Override
	public Exporter setFormat(SaryFormat format) {
		this.format = format;
		return this;
	}

	@Override
	public Exporter setOutput(String output) {
		this.output = output;
		return this;
	}

	@Override
	public Exporter setCanvas(SaryCanvas canvas) {
		this.canvas = canvas;
		return this;
	}

	@Override
	public void export() throws SaryExportException {

		final Dimension canvasDimension = canvas.getDimension();
		final int height = (int) canvasDimension.getHeight();
		final int width = (int) canvasDimension.getWidth();

		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		Graphics2D drawer = bufferedImage.createGraphics();

		canvas.drawAll(drawer);

		drawer.dispose();

		File file = new File(output);

		try {
			switch (format) {
			case PNG:
				if (isPNGOutput(output)) {
					output += ".png";
				}
				ImageIO.write(bufferedImage, "png", file);
				break;

			case JPG:
				if (isJPGOutput(output)) {
					output += ".jpg";
				}
				ImageIO.write(bufferedImage, "jpg", file);
				break;

			case GIF:
				if (isGIFOutput(output)) {
					output += ".gif";
				}
				ImageIO.write(bufferedImage, "gif", file);
				break;

			default:
				;// Ne rien faire ...

			}
		} catch (Exception e) {
			throw new SaryExportException(e);
		}

	}

	private boolean isPNGOutput(String output) {
		return !output.endsWith(".png") || !output.endsWith(".PNG");
	}

	private boolean isJPGOutput(String output) {
		return !output.endsWith(".jpg") || !output.endsWith(".JPG");
	}

	private boolean isGIFOutput(String output) {
		return !output.endsWith(".gif") || !output.endsWith(".GIF");
	}

	@Override
	public SaryFormat getFormat() {
		return format;
	}

	@Override
	public String getOutput() {
		return output;
	}

	@Override
	public SaryCanvas getCanvas() {
		return canvas;
	}

}
