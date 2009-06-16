package sapient.features.collection;

import java.util.ArrayList;
import java.util.List;

import sapient.features.Feature;



/**
 * A Feature Collections consists many features (and can itself be 
 * considered as feature)
 * 
 * @author pajoma
 *
 */
public class FeatureCollection extends Feature {
		
	private List<Feature> features = null;

	public void addFeatures(List<Feature> features) {
		this.getFeatures().addAll(features);
	}
	
	public void addFeature(Feature f) {
		this.getFeatures().add(f);
	}

	public List<Feature> getFeatures() {
		if (features == null) {
			features = new ArrayList<Feature>();	
		}

		return features;
	}
}
