package sapient.features.streams.kml;

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


import samples.SamplesAnchor;
import sapient.features.Feature;
import sapient.features.streams.factories.KMLFeatureFactory;
import sapient.features.streams.kml.KMLParser;

public class TestHarbors {

	String name = "DestinationsAndGauges_v05.kml";

	
	
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
		KML kml = parser.start(SamplesAnchor.class.getResourceAsStream(name));
		KMLFeatureFactory factory = new KMLFeatureFactory();
		
		for(Document d : kml.getDocuments()) {
			List<KMLFeature> l = d.listFeaturesRecursive(Placemark.class);

			for(KMLFeature kf : l) {
				Placemark p = (Placemark) kf;
				Feature f = factory.createFeature(p);
				
				System.out.println(f.listAnnotations());
				System.out.println(f.getGeometry().toString());
				
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
