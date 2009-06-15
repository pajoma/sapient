package xstreamkml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.google.earth.kml.Document;
import com.google.earth.kml.Folder;
import com.google.earth.kml.Kml;
import com.google.earth.kml.KmlFeature;
import com.google.earth.kml.KmlGeometry;
import com.google.earth.kml.LineString;
import com.google.earth.kml.LinearRing;
import com.google.earth.kml.MultiGeometry;
import com.google.earth.kml.Placemark;
import com.google.earth.kml.Point;
import com.google.earth.kml.Polygon;
import com.google.earth.kml.innerBoundaryIs;
import com.google.earth.kml.outerBoundaryIs;
import java.util.Iterator;
import java.util.List;

public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        QNameMap qnameMap = new QNameMap();
        qnameMap.setDefaultNamespace("http://earth.google.com/kml/2.0");
        XStream xstream = new XStream( new StaxDriver(qnameMap));
        
        xstream.alias("kml", Kml.class);
        
        // Features
        
        xstream.alias("Document", Document.class);
        xstream.alias("Folder", Folder.class);
        xstream.alias("Placemark", Placemark.class);
        
        // Geometries
        
        xstream.alias("MultiGeometry", MultiGeometry.class);
        xstream.alias("Point", Point.class);
        xstream.alias("LineString", LineString.class);
        xstream.alias("LinearRing", LinearRing.class);
        xstream.alias("Polygon", Polygon.class);
        xstream.alias("innerBoundaryIs", innerBoundaryIs.class);
        xstream.alias("outerBoundaryIs", outerBoundaryIs.class);
        
        xstream.addImplicitCollection(innerBoundaryIs.class, "innerBoundaries", LinearRing.class);
        
        xstream = handleFeatureCollections(xstream, Kml.class);
        xstream = handleFeatureCollections(xstream, Document.class);
        xstream = handleFeatureCollections(xstream, Folder.class);
        
        xstream = handleGeometryCollections(xstream, Placemark.class);
        xstream = handleGeometryCollections(xstream, MultiGeometry.class);
        
        xstream = ignoreFields(xstream);
        
        String filename = "KML_Samples.kml";
        
        File file = new File(filename);
        
        // Read KML file
        
        FileInputStream fis = new FileInputStream(file);
        Kml kml = (Kml) xstream.fromXML(fis);
        fis.close();
        
        // Write KML file
        
        FileOutputStream fos = new FileOutputStream("out.xml");
        xstream.toXML(kml, fos);
        
        // Traverse Kml Object

        TraverseKml(kml);
    }
    
    private static XStream handleFeatureCollections(XStream xstream, Class clazz){
        xstream.addImplicitCollection(clazz, "features", Document.class);
        xstream.addImplicitCollection(clazz, "features", Folder.class);
        xstream.addImplicitCollection(clazz, "features", Placemark.class);
        return xstream;
    }
    
    private static XStream handleGeometryCollections(XStream xstream, Class clazz){
        xstream.addImplicitCollection(clazz, "geometries", MultiGeometry.class);
        xstream.addImplicitCollection(clazz, "geometries", Point.class);
        xstream.addImplicitCollection(clazz, "geometries", LineString.class);
        xstream.addImplicitCollection(clazz, "geometries", LinearRing.class);
        xstream.addImplicitCollection(clazz, "geometries", Polygon.class);
        return xstream;
    }
    
    private static XStream ignoreFields(XStream xstream){
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
        return xstream;
    }
    
    public static void TraverseKml(Kml kml){
        System.out.println("Traversing Kml...");
        Iterator i = kml.getFeatures().iterator();
        while (i.hasNext()){
            KmlFeature f = (KmlFeature) i.next();
            TraverseKmlFeatures(f);
        }
        System.out.println();
        System.out.println("Completed Kml traversal.");
    }
    
    public static void TraverseKmlFeatures(KmlFeature f){        
        Iterator i;
        if (f instanceof Document){
            System.out.println("Document::" + f.getName());
            List fl = ((Document)f).getFeatures();
            if (fl!=null){
                i = fl.iterator();
                while (i.hasNext()){
                    KmlFeature ff = (KmlFeature) i.next();
                    TraverseKmlFeatures(ff);
                }
            }
        }
        if (f instanceof Folder){
            System.out.println("Folder::" + f.getName());
            List fl = ((Folder)f).getFeatures();
            if (fl!=null){
                i = fl.iterator();
                while (i.hasNext()){
                    KmlFeature ff = (KmlFeature) i.next();
                    TraverseKmlFeatures(ff);
                }
            }
        }
        if (f instanceof Placemark){
            System.out.println("Placemark::" + f.getName());
            List g = ((Placemark)f).getGeometries();
            if (g!=null){
                i = g.iterator();
                while (i.hasNext()){
                    KmlGeometry gg = (KmlGeometry) i.next();
                    if (gg instanceof LinearRing) System.out.println("Geometry::LinearRing");
                    if (gg instanceof LineString) System.out.println("Geometry::LineString");
                    if (gg instanceof MultiGeometry) System.out.println("Geometry::MultiGeometry");
                    if (gg instanceof Point) System.out.println("Geometry::Point");
                    if (gg instanceof Polygon) System.out.println("Geometry::Polygon");
                }
            }
            
        }
        
    }
    
}
