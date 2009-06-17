package sapient.features.streams.kml;

import org.geospatial.kml.Document;
import org.geospatial.kml.Folder;
import org.geospatial.kml.KML;
import org.geospatial.kml.KMLContainer;
import org.geospatial.kml.KMLFeature;
import org.geospatial.kml.Placemark;
import org.geospatial.kml.geometries.KMLGeometry;
import org.geospatial.kml.geometries.LineString;
import org.geospatial.kml.geometries.LinearRing;
import org.geospatial.kml.geometries.MultiGeometry;
import org.geospatial.kml.geometries.Point;
import org.geospatial.kml.geometries.Polygon;
import org.geospatial.kml.geometries.innerBoundaryIs;
import org.geospatial.kml.geometries.outerBoundaryIs;
import org.geospatial.kml.geometries.converters.LineStringConverter;
import org.geospatial.kml.geometries.converters.LinearRingConverter;
import org.geospatial.kml.geometries.converters.PointConverter;
import org.geospatial.kml.styles.Style;

import com.thoughtworks.xstream.XStream;

public class XStreamsConfiguration {

	public void configure(XStream xs) {

//		this.configureManually(xs);
		this.registerAnnotations(xs);
		

	}
	
	private void registerAnnotations(XStream xstream) {
		xstream.processAnnotations(KML.class);

		xstream.processAnnotations(Placemark.class);
		xstream.processAnnotations(Document.class);
		xstream.processAnnotations(Folder.class);
		xstream.processAnnotations(KMLContainer.class);
		xstream.processAnnotations(KMLFeature.class);
		xstream.processAnnotations(KMLGeometry.class);
		xstream.processAnnotations(Style.class);

		xstream.processAnnotations(LineString.class);
		xstream.processAnnotations(Point.class);
			
		
	}



	private void configureManually(XStream xs) {
		// kml
		xs.alias("kml", KML.class);
		xs.addImplicitCollection(KML.class, "documents", Document.class);

		// folder
		xs.alias("Document", Document.class);

		xs.alias("Folder", Folder.class);
		xs.alias("Placemark", Placemark.class);
		xs.addImplicitCollection(Document.class, "containedFeatures",
				Folder.class);
		xs.addImplicitCollection(Document.class, "containedFeatures",
				Placemark.class);

		// geometries
		xs.alias("MultiGeometry", MultiGeometry.class);
		xs.alias("Point", Point.class);
			xs.alias("LineString", LineString.class);
		xs.alias("LinearRing", LinearRing.class);
		xs.alias("Polygon", Polygon.class);
		xs.alias("innerBoundaryIs", innerBoundaryIs.class);
		xs.alias("outerBoundaryIs", outerBoundaryIs.class);

		handleGeometryCollections(xs, Placemark.class);
		handleGeometryCollections(xs, MultiGeometry.class);

		ignoreFields(xs);
		
		registerConverters(xs);
		
	}

	private void registerConverters(XStream xs) {
		xs.registerConverter(new PointConverter());
		xs.registerConverter(new LineStringConverter());
		xs.registerConverter(new LinearRingConverter());

	}
	
	private void handleGeometryCollections(XStream xs, Class cls) {
		xs.addImplicitCollection(cls, "geometries", MultiGeometry.class);
		xs.addImplicitCollection(cls, "geometries", Point.class);
		xs.addImplicitCollection(cls, "geometries", LineString.class);
		xs.addImplicitCollection(cls, "geometries", LinearRing.class);
		xs.addImplicitCollection(cls, "geometries", Polygon.class);
	}

	private void ignoreFields(XStream xstream) {
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
