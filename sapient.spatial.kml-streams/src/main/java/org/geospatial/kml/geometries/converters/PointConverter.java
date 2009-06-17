package org.geospatial.kml.geometries.converters;

import org.geospatial.kml.geometries.Point;

import sapient.features.streams.kml.converter.CoordinateConverter;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class PointConverter extends CoordinateConverter<Point> {

	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		super.writeCoordinates((Point) source, writer);
	}

	public Point unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		return super.readCoordinate(new Point(), reader);
	}
	
	public boolean canConvert(Class type) {
		return type.equals(Point.class);
	}
}

