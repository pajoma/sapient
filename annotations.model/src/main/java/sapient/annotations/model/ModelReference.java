package sapient.annotations.model;

import java.net.URL;

/**
 * A network link pointing to a concept in a RDF-encoded document, e.g. 
 * an ontology.
 * 
 * @author pajoma
 *
 */
public class ModelReference extends NetworkLink {
	private static final long serialVersionUID = 1l;
	
	public ModelReference(Object entity, URL url) {
		super(entity, url);
	}

}
