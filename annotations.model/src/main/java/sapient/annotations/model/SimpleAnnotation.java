package sapient.annotations.model;


/**
 * Simple Feature Annotation with a unspecified String as value.
 * 
 * @author pajoma
 *
 */
public class SimpleAnnotation extends Annotation {
	private static final long serialVersionUID = -3755493129412692900L;
	private final String value;
	

	public SimpleAnnotation(Object feature, String value) {
		super(feature);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return getValue();
	}
}
