package org.geospatial.kml.geometries;

import java.util.List;

import org.geospatial.kml.geometries.converters.LineStringConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.vividsolutions.jts.geom.Coordinate;


@XStreamAlias("LineString")
@XStreamConverter(value = LineStringConverter.class)
public class LineString extends KMLGeometry {
    
	@XStreamAlias("tessellate")
	public String tessellate;

	public LineString(List<Coordinate> pointList) {
		if(pointList != null) super.listCoordinates().addAll(pointList);
	}

	public LineString() {
		this(null);
	}


}
