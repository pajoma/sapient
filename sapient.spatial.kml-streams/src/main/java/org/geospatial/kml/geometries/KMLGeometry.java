package org.geospatial.kml.geometries;

import java.util.ArrayList;
import java.util.List;

import com.vividsolutions.jts.geom.Coordinate;

public abstract class KMLGeometry {
    
//	public KMLGeometry() {
//		System.err.println("This constructor should not be invoked");
//	}
	
	private List<Coordinate> coordinates = null;
	
	public List<Coordinate> listCoordinates() {
		if (coordinates == null) {
			coordinates = new ArrayList<Coordinate>();			
		}

		return coordinates;
	}
	
	public void addCoordinate(Coordinate p) {
		listCoordinates().add(p);
	}
	
	
}
