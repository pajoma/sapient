package org.geospatial.kml.geometries;
/* */
import org.geospatial.kml.geometries.converters.PointConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.vividsolutions.jts.geom.Coordinate;


@XStreamAlias("Point")
@XStreamConverter(value = PointConverter.class)
public class Point extends KMLGeometry {
	
	
	public Point(Coordinate c) {
		if(c != null) super.listCoordinates().add(c);
	}


	public Point() {
		this(null);
	}


	/**
	 * A Point has only one associated coordinate
	 * @return
	 * 		the coordinate associated to this point
	 */
	public Coordinate getCoordinate() {
		return super.listCoordinates().get(0);
	}
	
	
	
	}

