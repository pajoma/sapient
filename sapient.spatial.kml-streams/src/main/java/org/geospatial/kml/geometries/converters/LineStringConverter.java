package org.geospatial.kml.geometries.converters;

import org.geospatial.kml.geometries.LineString;
import org.geospatial.kml.geometries.Point;

import sapient.features.streams.kml.converter.CoordinateConverter;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.vividsolutions.jts.util.Assert;

public class LineStringConverter extends CoordinateConverter<LineString> {
	/*
	 * <LineString>
					<coordinates>
						-0.714496,44.837557,0 -0.71376,44.83807,0
						-0.71293,44.83746900000001,0
						-0.713662,44.836958,0
						-0.714496,44.837557,0 </coordinates>
				</LineString>
	*/


		public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
			super.writeCoordinates((LineString) source, writer);
		}

		public LineString unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
			Assert.equals("LineString", reader.getNodeName());
			return super.readCoordinates(new LineString(), reader);
		}
		
		public boolean canConvert(Class type) {
			return type.equals(LineString.class);
		}
	}



