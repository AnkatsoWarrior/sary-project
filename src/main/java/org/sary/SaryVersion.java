/**
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

import java.io.Serializable;


/**
 * Permet de savoir la version de la librairie utilisee.
 * 
 * @author Nabil Andriantomanga <nabil.arrowbase at gmail.com>
 * @since 1.0
 * 
 */
public class SaryVersion implements Comparable<SaryVersion>, Serializable {

	private final int version = 1;

	private final String versionString = "version 1.0";

	private static final long serialVersionUID = 1L;

	public int getVersion() {
		return version;
	}

	public String getVersionString() {
		return versionString;
	}

	@Override
	public int compareTo(SaryVersion otherVersion) {

		if (otherVersion.getVersion() > version) {
			return -1;
		}

		if (otherVersion.getVersion() < version) {
			return 1;
		}

		return 0;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + version;
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaryVersion other = (SaryVersion) obj;
		if (version != other.version)
			return false;
		return true;
	}

}
