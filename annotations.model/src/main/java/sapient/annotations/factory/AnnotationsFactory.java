package sapient.annotations.factory;

import sapient.annotations.model.contact.*;
import sapient.annotations.model.*;

public class AnnotationsFactory {

	private boolean isEmpty(String str) {
		return ((str == null) || (str.matches("")));
	}
	
	public Name createName(Object f, String value) {
		if(isEmpty(value)) return null;
		else return new Name(f, value);
	}

	
	public Description createDescription(Object f, String value) {
		if(isEmpty(value)) return null;
		else return new Description(f, value);
	}
	
	
	public Address createAddress(Object f, String value) {
		if(isEmpty(value)) return null;
		else return new Address(f, value);
	}
}
