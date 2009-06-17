package sapient.features.factories;


import sapient.features.Feature;

import com.vividsolutions.jts.geom.PrecisionModel;


public abstract class FeatureFactory {

	protected GeometryFactory geomFactory = null;

	
	/**
	 * Constructor, has to be called by implementing sub classes to 
	 * specify the spatial reference system which we want to use for
	 * all features created by this factory.
	 *  
	 * Sets the spatial reference system. 
	 * 
	 * @param srs
	 */
	protected FeatureFactory() {
		
	}

	


	public abstract Feature createFeature();	

	public  GeometryFactory getGeometryFactory(int srs) {
		if(geomFactory == null) {
			geomFactory = new GeometryFactory();
		}
		return geomFactory;
	}


}
