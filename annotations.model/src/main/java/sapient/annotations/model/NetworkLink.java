package sapient.annotations.model;

import java.net.URL;

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

	public NetworkLink(Object entity, URL url) {
		super(entity);
		this.url = url;
		
	}
	
	public URL getURL() {
		return url;
	}
	
}
