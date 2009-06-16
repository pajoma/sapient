package sapient.features;



import java.util.ArrayList;
import java.util.List;

import sapient.features.annotations.Annotation;
import sapient.features.geometries.Geometry;

/**
 * A feature is a "a prominent attribute or aspect of something", e.g. on a map.(wordnet) 
 * According to Wikipedia, "a feature (in GIS) is an entity with a geographic location, 
 * typically describable by (for example) points, arcs, or polygons." 
 * 
 * A feature has one geometry associated (which can be a multigeometry). A feature has
 * one or more annotations (ranging from simple preferred labels to model references
 * pointing to ontological descriptions).  
 * 
 * @author pajoma
 *
 */
public abstract class Feature {

	private List<Annotation> annotList;
	private Geometry geom;

	
	/**
	 * Sets the geometry of the feature
	 * 
	 * @param geom
	 */
	public void setGeometry(Geometry geom) {
		this.geom = geom;
	}
	
	
	public Geometry getGeometry() {
		return this.geom;
	}
	
	/**
	 * @param annot
	 */
	public void addAnnotation(Annotation annot) {
		this.listAnnotations(null).add(annot);		
	}
	
	
	/**
	 * @param filter
	 * @return
	 */
	public List<Annotation> listAnnotations(Class filter) {
		if(this.annotList == null) {
			annotList = new ArrayList<Annotation>();
		}

		if(filter != null) {
			
		}
		
		return annotList;
	}
	
}
