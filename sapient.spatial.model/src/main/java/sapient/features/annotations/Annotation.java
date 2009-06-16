package sapient.features.annotations;

import java.io.Serializable;

import sapient.features.Feature;

public abstract class Annotation implements Serializable {
	private static final long serialVersionUID = -5913899782279824176L;
	
	private final Feature feature;

	public Annotation(Feature feature) {
		this.feature = feature;
	}
	
	public Feature getAssociatedFeature() {
		return feature;
	}
}
