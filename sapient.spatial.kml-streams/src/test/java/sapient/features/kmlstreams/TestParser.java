package sapient.features.kmlstreams;

import java.util.List;

import org.geospatial.kml.Document;
import org.geospatial.kml.Folder;
import org.geospatial.kml.KML;
import org.geospatial.kml.KMLFeature;
import org.geospatial.kml.Placemark;
import org.geospatial.kml.geometries.KMLGeometry;
import org.geospatial.kml.geometries.Point;
import org.junit.Assert;
import org.junit.Test;


import sapient.features.streams.kml.KMLParser;

public class TestParser {

	String t1 = "InlandWaterways_v07.kml";
	String t2 = "DestinationsAndGauges_v05.kml";
	String t3 = "test.kml";
	String t4 = "easy.kml";
	
//	@Test
//	public void parseGeosoftFile() {
//		KMLParser parser = new KMLParser();
//		KML kml = parser.start(TestParser.class.getResourceAsStream(t1));
//		
//		for(KMLFeature f : kml.getDocuments()) {
//			System.out.println(f);
//		}
//	}
//	
//	
	@Test
	public void parseHarbors() {
		KMLParser parser = new KMLParser();
		KML kml = parser.start(TestParser.class.getResourceAsStream(t2));
		
		for(Document f : kml.getDocuments()) {
			List<KMLFeature> l = f.listFeaturesRecursive(Placemark.class);
			
			for(KMLFeature kf : l) {
				Placemark p = (Placemark) kf;
				
				System.out.print(kf.getName());
				for(KMLGeometry geo : p.listGeometries()) {
					//Point point = (Point) geo;
					System.out.println("  " + geo.getClass());
				}
			}
		}
	}
	
	@Test
	public void parseEasy() {
		KMLParser parser = new KMLParser();
		KML kml = parser.start(TestParser.class.getResourceAsStream(t4));

		Assert.assertNotNull(kml);
		
		List<Document> documents = kml.getDocuments();
		
		
		for(Document f : documents) {
			List<KMLFeature> l = f.listFeaturesRecursive();
			System.out.println(l.size());
			
			for(KMLFeature kf : l) {
				System.out.print(kf.getClass());
				System.out.print(" :: ");
				System.out.println(kf.getName());
			}
		}
	}
	
//	@Test
//	public void parseOtherFile() {
//		KMLParser parser = new KMLParser();
//		KML kml = parser.start(TestParser.class.getResourceAsStream(t3));
//		
//		
//	}
}
