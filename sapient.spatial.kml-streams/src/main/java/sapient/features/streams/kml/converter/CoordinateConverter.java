package sapient.features.streams.kml.converter;

import org.geospatial.kml.geometries.KMLGeometry;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.util.Assert;


public abstract class CoordinateConverter<T extends KMLGeometry> implements Converter {

	protected void writeCoordinates(T p, HierarchicalStreamWriter writer) {
		try {
			writer.startNode("coordinates");
			StringBuffer sb = new StringBuffer();
			for(Coordinate c : p.listCoordinates()) {
				sb.append(c.x).append(",")
				  .append(c.y).append(",")
				  .append(c.z).append(" ");
			}
			writer.setValue(sb.toString());
			
		} catch (Exception e) {
			System.out.println("CoordinateConverter.writeCoordinates()");
			e.printStackTrace();
			
		} finally {
			writer.endNode();
		}

	}

	protected T readCoordinate(T geom, HierarchicalStreamReader reader) {
		return this.addCoordinate(geom, getCoordinatesValue(reader));
	}
	
	protected T readCoordinates(T geom, HierarchicalStreamReader reader) {
		return this.addCoordinates(geom, getCoordinatesValue(reader));
	}
	
	private String getCoordinatesValue(HierarchicalStreamReader reader) {
		if(! reader.hasMoreChildren()) return null;
		
		try {
			while(reader.hasMoreChildren()) {
				reader.moveDown();
				if(reader.getNodeName().matches("coordinates")) break;
				else reader.moveUp();
			}
		
			return reader.getValue();
		} finally {
			reader.moveUp();
		}		
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
		try {
			String[] points = line.split(" ");
			
			/* and then we add each point definition again and create new points */
			for(String str : points) {
				this.addCoordinate(geom, str);
			}
			return geom;
		} catch (Exception e) {
			System.out.println("CoordinateConverter.addCoordinates()");
			e.printStackTrace();
		}
		return null;
	
	}
	
	private Coordinate extractCoordinate(String line) {
		Coordinate c = null;
		try {
			c = new Coordinate();
			String[] split = line.split(",");
			Assert.equals(split.length, 3);
			
			// lat = y
			// lon = x 
			// lat / lon / height
			c.y = Double.parseDouble(split[0]);
			c.x = Double.parseDouble(split[1]);
			c.z = Double.parseDouble(split[2]);
			
		} catch (Exception e) {
			
		}
		return c;
	}

}
