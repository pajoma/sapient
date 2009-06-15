package org.geospatial.kml;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;


@XStreamAlias("kml")
public class KML {
	
	@XStreamAlias("Document")
	@XStreamImplicit
	private List<Document> documents;

	/**
	 * Returns the first document
	 * @return
	 */
	public List<Document> getDocuments() {
		if (documents == null) {
			documents = new ArrayList<Document>();	
		}
		return documents;
	}
//	/* (non-Javadoc)
//	 * @see sapient.features.collection.FeatureCollection#getFeatures()
//	 */
//	public List<Feature> getFeatures() {
//		List<Feature> res = new ArrayList<Feature>();
//		
//		// TODO: create features from KML (should include Folders & Document 
//		// as FeatureCollections and Placemarks as Features)
//		return res;
//	}
//	/* (non-Javadoc)
//	 * @see sapient.features.collection.FeatureCollection#getFeatures()
//	 */
//	public List<Feature> getFeatures() {
//		List<Feature> res = new ArrayList<Feature>();
//		
//		// TODO: create features from KML (should include Folders & Document 
//		// as FeatureCollections and Placemarks as Features)
//		return res;
//	}
	
}
