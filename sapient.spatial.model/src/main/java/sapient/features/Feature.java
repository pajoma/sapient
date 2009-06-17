package sapient.features;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;


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

	private List<Serializable> annotList;
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
	public void addAnnotation(Serializable annot) {
		if(annot != null) this.listAnnotations(null).add(annot);		
	}
	
	
	/**
	 * @param filter
	 * @return
	 */
	public List<Serializable> listAnnotations(Class filter) {
		if(this.annotList == null) {
			annotList = new ArrayList<Serializable>();
		}

		if(filter != null) {
			
		}
		
		return annotList;
	}
	
	
	/**
	 * @param filter
	 * @return
	 */
	public List<Serializable> listAnnotations() {
		return listAnnotations(null);
	}
}
