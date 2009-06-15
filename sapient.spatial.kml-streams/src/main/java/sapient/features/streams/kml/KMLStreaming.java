//package sapient.features.streams.kml;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.QNameMap;
//import com.thoughtworks.xstream.io.xml.StaxDriver;
//
//import sapient.features.kmlstreams.model.KML;
//
//
//
//public class KMLStreaming {
//
//
//
//private KML parse(InputStream in) throws IOException {
//
//	QNameMap qnameMap = new QNameMap();
//	qnameMap.setDefaultNamespace("http://www.opengis.net/kml/2.2");
//	XStream xstream = new XStream(new StaxDriver(qnameMap));
//	
//	xstream.alias("kml", KML.class);
//	// Features
//
//	xstream.alias("Document", Document.class);
//	xstream.alias("Folder", Folder.class);
//	xstream.alias("Placemark", Placemark.class);
//
//	// Geometries
//
//	xstream.alias("MultiGeometry", MultiGeometry.class);
//	xstream.alias("Point", Point.class);
//	xstream.alias("LineString", LineString.class);
//	xstream.alias("LinearRing", LinearRing.class);
//	xstream.alias("Polygon", Polygon.class);
//	xstream.alias("innerBoundaryIs", innerBoundaryIs.class);
//	xstream.alias("outerBoundaryIs", outerBoundaryIs.class);
//
//	xstream.addImplicitCollection(innerBoundaryIs.class, "innerBoundaries",
//			LinearRing.class);
//
//	handleFeatureCollections(xstream, Kml.class);
//	handleFeatureCollections(xstream, Document.class);
//	handleFeatureCollections(xstream, Folder.class);
//	
//	xstream.addImplicitCollection(Kml.class, "documents", Document.class);
//	xstream.addImplicitCollection(Document.class, "placemarks", Placemark.class);
//
//	handleGeometryCollections(xstream, Placemark.class);
//	handleGeometryCollections(xstream, MultiGeometry.class);
//	
//	// Geometries
//	xstream.addImplicitCollection(Placemark.class, "multiGeometries", MultiGeometry.class);
//	xstream.addImplicitCollection(Placemark.class, "points", Point.class);
//	xstream.addImplicitCollection(Placemark.class, "lineStrings", LineString.class);
//	xstream.addImplicitCollection(Placemark.class, "linearRings", LinearRing.class);
//	xstream.addImplicitCollection(Placemark.class, "polygons", Polygon.class);
//
//	ignoreFields(xstream);
//	
//	
//    // Read KML file
//    
//    FileInputStream fis = new FileInputStream(file);
//    Kml kml =  (Kml) xstream.fromXML(fis);
//    fis.close();
//    
//    return kml;
//}