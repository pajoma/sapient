package org.geospatial.kml.geometries.converters;

import java.util.List;

import org.geospatial.kml.geometries.LinearRing;
import org.geospatial.kml.geometries.Point;

import sapient.features.streams.kml.converter.CoordinateConverter;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.vividsolutions.jts.geom.Coordinate;

/**
 * @author pajoma
 * 
 */
public class LinearRingConverter extends CoordinateConverter<LinearRing> {

	public void marshal(Object source, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		super.writeCoordinates((LinearRing) source, writer);
	}

	public LinearRing unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		LinearRing ring = super.readCoordinates(new LinearRing(), reader);

		List<Coordinate> all = ring.listCoordinates();
		Coordinate first = all.get(0);
		Coordinate last = all.get(all.size());
		if (last.equals3D(first))
			return ring;
		else
			return null; // throw new InvalidGeometryException(ring,
							// "validation.geometry.unclosedLineString");

	}

	public boolean canConvert(Class type) {
		return type.equals(LinearRing.class);
		// also valid for innerBoundary, outBoundary
	}
}
