package org.geospatial.kml;

import java.util.ArrayList;
import java.util.List;

import org.geospatial.kml.styles.Style;
import org.geospatial.kml.styles.StyleMap;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;




public class KMLContainer extends KMLFeature {
    
	@XStreamImplicit
	protected List<KMLFeature> containedFeatures;
    
	@XStreamImplicit
	@XStreamAlias("Style")
	protected List<Style> styles = new ArrayList<Style>();
	
	@XStreamImplicit
	@XStreamAlias("StyleMap")
	protected List<StyleMap> styleMaps = new ArrayList<StyleMap>();
	
	
	/**
	 * Lists all features in this container which are instance of the given class
	 * @param filter, the class, e.g. Placemark.class
	 * @return the list of features
	 */
	public List<KMLFeature> listFeatures(Class... filter) {
		if(filter == null) return containedFeatures;
		List<KMLFeature> res = new ArrayList<KMLFeature>();
		for(KMLFeature f : this.containedFeatures) {
			
			for(Class cls : filter) {
				if(f.getClass().equals(cls)) { 
					res.add(f);	
					break;
				}
			}
			
		}
		return res;
		
	}
	
	/**
	 * Lists all features in this container
	 * 
	 * @return all features 
	 */
	public List<KMLFeature> listFeatures() {
		return listFeatures(null);
	}
	
	/**
	 * Lists all features in this container recursively
	 * 
	 * @return all features 
	 */
	public List<KMLFeature> listFeaturesRecursive() {
		return listFeaturesRecursive(null);
	}
	
	/**
	 * Lists all features in this container recursively, using a filter
	 * 
	 * @return all features 
	 */
	public List<KMLFeature> listFeaturesRecursive(Class... filters) {
		// recursive (not iterative), may have better performance
		List<KMLFeature> res = new ArrayList<KMLFeature>();
		
		for(KMLFeature f : this.containedFeatures) {
			if(f instanceof KMLContainer) {
				// if current feature is an container itself, we add all contained features (recursively)
				res.addAll(((KMLContainer)f).listFeaturesRecursive(filters));
			} else {
				// no container, then let's add it to the list (we have to care about the filter though)
				if(filters == null) res.add(f);
				else {
					for(Class cls : filters) {
						if(f.getClass().equals(cls)) { 
							res.add(f);	
							break;
						}
					}
						
				}
				
			}
		}
			
		return res;
	}

	
}
