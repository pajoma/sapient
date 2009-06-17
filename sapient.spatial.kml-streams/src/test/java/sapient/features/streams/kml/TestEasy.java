package sapient.features.streams.kml;

import java.util.List;

import org.geospatial.kml.Document;
import org.geospatial.kml.KML;
import org.geospatial.kml.KMLFeature;
import org.junit.Assert;
import org.junit.Test;

import samples.SamplesAnchor;

public class TestEasy {

	String file = "easy.kml";
	
	@Test
	public void parseEasy() {
		KMLParser parser = new KMLParser();
		KML kml = parser.start(SamplesAnchor.class.getResourceAsStream(file));

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
}
