package sapient.features.streams.kml;

import java.text.DecimalFormat;
import java.util.List;

import org.geospatial.kml.Document;
import org.geospatial.kml.KML;
import org.geospatial.kml.KMLFeature;
import org.geospatial.kml.Placemark;
import org.junit.Test;

import samples.SamplesAnchor;
import sapient.annotations.model.contact.Name;
import sapient.features.Feature;
import sapient.features.operations.GeodeticDistance;
import sapient.features.streams.factories.KMLFeatureFactory;

import com.vividsolutions.jts.geom.LineString;

public class TestWaterWays {

	String name = "InlandWaterways_v07.kml";

	// Spree, 11.733 km
	// Fulda, 136.566 km
	@Test
	public void parseHarbors() throws Exception {
		KMLParser parser = new KMLParser();
		KML kml = parser.start(SamplesAnchor.class.getResourceAsStream(name));
		KMLFeatureFactory factory = new KMLFeatureFactory();
		
		
		
		for(Document d : kml.getDocuments()) {
			List<KMLFeature> l = d.listFeaturesRecursive(Placemark.class);
			
			
			
			for(KMLFeature kf : l) {
				Placemark p = (Placemark) kf;

				Feature f = factory.createFeature(p);
				LineString geometry = (LineString) f.getGeometry();
				double length = new GeodeticDistance().length(geometry); 
				
				System.out.println(f.listAnnotations(Name.class));
				System.out.println("Distance: "+DecimalFormat.getInstance().format(length/1000)+" km");
				
				

			}
		}
	}
	


}
