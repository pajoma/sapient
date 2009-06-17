package org.geospatial.kml;

import java.util.ArrayList;
import java.util.List;

import org.geospatial.kml.sugar.LookAt;

import sapient.features.collection.FeatureCollection;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;



/**
 * Everything in KML is a feature, not that this not a Spatial 
 * Feature in our sense
 * @author pajoma
 *
 */
public class KMLFeature {
    
	@XStreamAlias("address")
	protected String address = null;
	
	@XStreamAlias("name")
	protected String name = null;
	
	@XStreamAlias("description")
	protected String description = null;
	
	/** @see http://code.google.com/apis/kml/documentation/kmlreference.html#extendeddata */
	@XStreamAlias("ExtendedData")
	protected String extendedData = null;
	
	@XStreamAlias("Snippet")
	protected String snippet = null;
	
	@XStreamAlias("LookAt")
	protected LookAt lookAt;
	
	private FeatureCollection associatedFeatureCollection;
	


	
	
//	
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	/**
	 * Return the collection this feature has been associated to 
	 * @return
	 */
	public FeatureCollection associatedFeatureCollection() {
		// TODO: 
		return this.associatedFeatureCollection;
		
	}
        
}
