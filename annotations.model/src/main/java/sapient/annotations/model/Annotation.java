// license, apache 2.0

package sapient.annotations.model;

import java.io.Serializable;



public abstract class Annotation implements Serializable {
	private static final long serialVersionUID = -5913899782279824176L;
	
	private final Object entity;

	public Annotation(Object entity) {
		this.entity = entity;
	}

	public Object getAnnotatedEntity() {
		return entity;
	}


	

}
