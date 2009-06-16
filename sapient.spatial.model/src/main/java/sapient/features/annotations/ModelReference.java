package sapient.features.annotations;

import java.net.URL;

import sapient.features.Feature;

/**
 * A network link pointing to a concept in a RDF-encoded document, e.g. 
 * an ontology.
 * 
 * @author pajoma
 *
 */
public class ModelReference extends NetworkLink {
	private static final long serialVersionUID = 1l;
	
	public ModelReference(Feature feature, URL url) {
		super(feature, url);
	}

}
