package org.geospatial.kml;

import java.util.ArrayList;
import java.util.List;

import org.geospatial.kml.geometries.KMLGeometry;
import org.geospatial.kml.geometries.Point;
import org.geospatial.kml.geometries.converters.PointConverter;



import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Placemark")
public class Placemark extends KMLFeature {
	
	// if annotated, he doesn't invoke the converter marshaller
	
	// if not annotated he create KMLGeometry, invokes marshaller, asks for points in placemarks
	
	
	@XStreamConverter(value = PointConverter.class)
	@XStreamImplicit
	private List<KMLGeometry> geometries;


//	private String Snippet;
    @XStreamAlias("styleUrl")
    private String styleUrl;	
//    
    public List<KMLGeometry> listGeometries() {
        if(geometries == null) {
        	geometries = new ArrayList<KMLGeometry>();
    	}
        return geometries;
    
    }

    public void setGeometries(List<KMLGeometry> geometries) {
        listGeometries().addAll(geometries);
    }
    
    public void addGeometry(KMLGeometry geometry) {
    	listGeometries().add(geometry);
    }

    
    
}

