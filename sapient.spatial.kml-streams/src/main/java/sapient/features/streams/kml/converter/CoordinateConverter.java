package sapient.features.streams.kml.converter;

import org.geospatial.kml.geometries.KMLGeometry;
import org.geospatial.kml.geometries.Point;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.vividsolutions.jts.geom.Coordinate;


public abstract class CoordinateConverter<T extends KMLGeometry> implements Converter {

	protected void writeCoordinates(T p, HierarchicalStreamWriter writer) {
		writer.startNode("coordinates");
		StringBuffer sb = new StringBuffer();
		for(Coordinate c : p.listCoordinates()) {
			sb.append(c.x).append(",")
			  .append(c.y).append(",")
			  .append(c.z).append(" ");
		}
		writer.setValue(sb.toString());
		writer.endNode();
	}

	protected T readCoordinate(T geom, HierarchicalStreamReader reader) {
		reader.moveDown();
		return this.addCoordinate(geom, reader.getValue());
		
	}
	
	protected T readCoordinates(T geom, HierarchicalStreamReader reader) {
		reader.moveDown();
		return this.addCoordinates(geom, reader.getValue());
		
	}
	
	/**
	 * Store one coordinate to the given geometry object
	 * @param geom
	 * @param line
	 */
	protected T addCoordinate(T geom, String line) {
		geom.addCoordinate(extractCoordinate(line));
		return geom;
	}
	
	/**
	 * Store a set of coordinates to the given geometry object
	 * @param geom
	 * @param line
	 */
	protected T addCoordinates(T geom, String line) {
		String[] points = line.split(" ");
		
		/* and then we add each point definition again and create new points */
		for(String str : points) {
			geom.addCoordinate(extractCoordinate(str));
		}
		return geom;
	}
	
	private Coordinate extractCoordinate(String line) {
		Coordinate c = new Coordinate();
		try {
			String[] split = line.split(",");

			c.x = Double.parseDouble(split[0]);
			c.y = Double.parseDouble(split[1]);
			c.z = Double.parseDouble(split[2]);
			
			System.out.println(c);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return c;
	}

}
