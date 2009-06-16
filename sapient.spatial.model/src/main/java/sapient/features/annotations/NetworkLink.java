package sapient.features.annotations;

import java.net.URL;

import sapient.features.Feature;

/**
 * An annotation connecting the feature to a remote description whose
 * location is the URL in the annotation
 * 
 * @author pajoma
 *
 */
public class NetworkLink extends Annotation {
	private static final long serialVersionUID = 1l;
	private final URL url;

	public NetworkLink(Feature feature, URL url) {
		super(feature);
		this.url = url;
		
	}
	
	public URL getURL() {
		return url;
	}
	
}
