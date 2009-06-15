package sapient.features.streams.kml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.geospatial.kml.*;
import org.geospatial.kml.geometries.*;
import org.geospatial.kml.styles.*;


import com.thoughtworks.xstream.XStream;

public class XStreamsConfiguration {

	public void configure(XStream xstream) {
	
	// kml	
	xstream.alias("kml", KML.class);
	xstream.addImplicitCollection(KML.class, "documents", Document.class);
    
    // folder
    xstream.alias("Document", Document.class);

   
    xstream.alias("Folder", Folder.class);
    xstream.alias("Placemark", Placemark.class);
    xstream.addImplicitCollection(Document.class, "containedFeatures", Folder.class);
    xstream.addImplicitCollection(Document.class, "containedFeatures", Placemark.class);
    
    // geometries
    xstream.alias("MultiGeometry", MultiGeometry.class);
    xstream.alias("Point", Point.class);
    xstream.alias("LineString", LineString.class);
    xstream.alias("LinearRing", LinearRing.class);
    xstream.alias("Polygon", Polygon.class);
    xstream.alias("innerBoundaryIs", innerBoundaryIs.class);
    xstream.alias("outerBoundaryIs", outerBoundaryIs.class);
    
    handleGeometryCollections(xstream, Placemark.class);
    handleGeometryCollections(xstream, MultiGeometry.class);
    
    ignoreFields(xstream);

}



private void handleGeometryCollections(XStream xstream, Class clazz){
    xstream.addImplicitCollection(clazz, "geometries", MultiGeometry.class);
    xstream.addImplicitCollection(clazz, "geometries", Point.class);
    xstream.addImplicitCollection(clazz, "geometries", LineString.class);
    xstream.addImplicitCollection(clazz, "geometries", LinearRing.class);
    xstream.addImplicitCollection(clazz, "geometries", Polygon.class);
}

private void ignoreFields(XStream xstream){
    xstream.alias("NetworkLinkControl", String.class);
    xstream.alias("NetworkLink", String.class);
    xstream.alias("GroundOverlay", String.class);
    xstream.alias("ScreenOverlay", String.class);
    xstream.alias("visibility", String.class);
    xstream.alias("open", String.class);
    xstream.alias("phoneNumber", String.class);
    xstream.alias("Snippet", String.class);
    xstream.alias("LookAt", String.class);
    xstream.alias("TimePrimitive", String.class);
    xstream.alias("styleUrl", String.class);
    xstream.alias("StyleSelector", String.class);
    xstream.alias("Style", String.class);
    xstream.alias("Region", String.class);
    xstream.alias("Metadata", String.class);
    xstream.alias("tessellate", String.class);
    xstream.alias("altitudeMode", String.class);
    xstream.alias("extrude", String.class);
    xstream.alias("StyleMap", String.class);
    xstream.addImplicitCollection(KMLContainer.class, "styleMaps", String.class);
}
}
