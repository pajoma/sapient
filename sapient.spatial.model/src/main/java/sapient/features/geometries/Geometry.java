package sapient.features.geometries;

import sapient.features.Feature;

import com.vividsolutions.jts.geom.GeometryFactory;



public abstract class Geometry extends com.vividsolutions.jts.geom.Geometry {

	
	private static final long serialVersionUID = 6654858064155635467L;

	
	public Geometry(Feature feature, GeometryFactory factory) {
		super(factory);
	}



	


	
	/**
	 * Well-known text (WKT) is a text markup language for representing vector 
	 * geometries as text.
	 * @return
	 */
	public String toWKT() {
		return super.toText();
	}
	
	/**
	 * Appends the WKT representation of the Geometry to the given StringBuffer
	 * 
	 * @param sb
	 * @return
	 */
	public StringBuffer appendWKT(StringBuffer sb) {
		return sb.append(super.toText());
	}

	
	
	

	
	
	
}
